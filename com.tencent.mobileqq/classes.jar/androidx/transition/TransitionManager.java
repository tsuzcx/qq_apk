package androidx.transition;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager
{
  private static final String LOG_TAG = "TransitionManager";
  private static Transition sDefaultTransition = new AutoTransition();
  static ArrayList<ViewGroup> sPendingTransitions = new ArrayList();
  private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal();
  private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap();
  private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap();
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup)
  {
    beginDelayedTransition(paramViewGroup, null);
  }
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup, @Nullable Transition paramTransition)
  {
    if ((!sPendingTransitions.contains(paramViewGroup)) && (ViewCompat.isLaidOut(paramViewGroup)))
    {
      sPendingTransitions.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = sDefaultTransition;
      }
      paramTransition = localTransition.clone();
      sceneChangeSetup(paramViewGroup, paramTransition);
      Scene.setCurrentScene(paramViewGroup, null);
      sceneChangeRunTransition(paramViewGroup, paramTransition);
    }
  }
  
  private static void changeScene(Scene paramScene, Transition paramTransition)
  {
    ViewGroup localViewGroup = paramScene.getSceneRoot();
    if (!sPendingTransitions.contains(localViewGroup))
    {
      Scene localScene = Scene.getCurrentScene(localViewGroup);
      if (paramTransition == null)
      {
        if (localScene != null) {
          localScene.exit();
        }
        paramScene.enter();
        return;
      }
      sPendingTransitions.add(localViewGroup);
      paramTransition = paramTransition.clone();
      paramTransition.setSceneRoot(localViewGroup);
      if ((localScene != null) && (localScene.isCreatedFromLayoutResource())) {
        paramTransition.setCanRemoveViews(true);
      }
      sceneChangeSetup(localViewGroup, paramTransition);
      paramScene.enter();
      sceneChangeRunTransition(localViewGroup, paramTransition);
    }
  }
  
  public static void endTransitions(ViewGroup paramViewGroup)
  {
    sPendingTransitions.remove(paramViewGroup);
    ArrayList localArrayList = (ArrayList)getRunningTransitions().get(paramViewGroup);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localArrayList = new ArrayList(localArrayList);
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Transition)localArrayList.get(i)).forceToEnd(paramViewGroup);
        i -= 1;
      }
    }
  }
  
  static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions()
  {
    Object localObject = (WeakReference)sRunningTransitions.get();
    if (localObject != null)
    {
      localObject = (ArrayMap)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new ArrayMap();
    WeakReference localWeakReference = new WeakReference(localObject);
    sRunningTransitions.set(localWeakReference);
    return localObject;
  }
  
  private Transition getTransition(Scene paramScene)
  {
    Object localObject = paramScene.getSceneRoot();
    if (localObject != null)
    {
      localObject = Scene.getCurrentScene((ViewGroup)localObject);
      if (localObject != null)
      {
        ArrayMap localArrayMap = (ArrayMap)this.mScenePairTransitions.get(paramScene);
        if (localArrayMap != null)
        {
          localObject = (Transition)localArrayMap.get(localObject);
          if (localObject != null) {
            return localObject;
          }
        }
      }
    }
    paramScene = (Transition)this.mSceneTransitions.get(paramScene);
    if (paramScene != null) {
      return paramScene;
    }
    return sDefaultTransition;
  }
  
  public static void go(@NonNull Scene paramScene)
  {
    changeScene(paramScene, sDefaultTransition);
  }
  
  public static void go(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    changeScene(paramScene, paramTransition);
  }
  
  private static void sceneChangeRunTransition(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new TransitionManager.MultiListener(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
  
  private static void sceneChangeSetup(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)getRunningTransitions().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).pause(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.captureValues(paramViewGroup, true);
    }
    paramViewGroup = Scene.getCurrentScene(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.exit();
    }
  }
  
  public void setTransition(@NonNull Scene paramScene1, @NonNull Scene paramScene2, @Nullable Transition paramTransition)
  {
    ArrayMap localArrayMap2 = (ArrayMap)this.mScenePairTransitions.get(paramScene2);
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      this.mScenePairTransitions.put(paramScene2, localArrayMap1);
    }
    localArrayMap1.put(paramScene1, paramTransition);
  }
  
  public void setTransition(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    this.mSceneTransitions.put(paramScene, paramTransition);
  }
  
  public void transitionTo(@NonNull Scene paramScene)
  {
    changeScene(paramScene, getTransition(paramScene));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.TransitionManager
 * JD-Core Version:    0.7.0.1
 */
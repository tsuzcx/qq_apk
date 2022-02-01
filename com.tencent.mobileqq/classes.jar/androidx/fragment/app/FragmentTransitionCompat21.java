package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FragmentTransitionCompat21
  extends FragmentTransitionImpl
{
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!isNullOrEmpty(paramTransition.getTargetIds())) || (!isNullOrEmpty(paramTransition.getTargetNames())) || (!isNullOrEmpty(paramTransition.getTargetTypes()));
  }
  
  public void addTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
  }
  
  public void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int j;
      if ((paramObject instanceof TransitionSet))
      {
        paramObject = (TransitionSet)paramObject;
        j = paramObject.getTransitionCount();
        while (i < j)
        {
          addTargets(paramObject.getTransitionAt(i), paramArrayList);
          i += 1;
        }
      }
      else if ((!hasSimpleTarget(paramObject)) && (isNullOrEmpty(paramObject.getTargets())))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          paramObject.addTarget((View)paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean canHandle(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object cloneTransition(Object paramObject)
  {
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).clone();
    }
    return localTransition;
  }
  
  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().addTransition(paramObject1).addTransition(paramObject2).setOrdering(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.addTransition(paramObject1);
      }
      paramObject2.addTransition(paramObject3);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = localObject;
        if (paramObject2 != null) {
          paramObject1 = paramObject2;
        }
      }
    }
    return paramObject1;
  }
  
  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void removeTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
  }
  
  public void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        replaceTargets(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!hasSimpleTarget(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.addTarget((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).addListener(new FragmentTransitionCompat21.2(this, paramView, paramArrayList));
  }
  
  public void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new FragmentTransitionCompat21.3(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void setEpicenter(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new FragmentTransitionCompat21.5(this, paramRect));
    }
  }
  
  public void setEpicenter(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      getBoundsOnScreen(paramView, localRect);
      paramObject.setEpicenterCallback(new FragmentTransitionCompat21.1(this, localRect));
    }
  }
  
  public void setListenerForTransitionEnd(@NonNull Fragment paramFragment, @NonNull Object paramObject, @NonNull CancellationSignal paramCancellationSignal, @NonNull Runnable paramRunnable)
  {
    ((Transition)paramObject).addListener(new FragmentTransitionCompat21.4(this, paramRunnable));
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.getTargets();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      bfsAddViewChildren(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object wrapTransitionInSet(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    return localTransitionSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21
 * JD-Core Version:    0.7.0.1
 */
package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;

class TransitionManager$MultiListener
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  ViewGroup mSceneRoot;
  Transition mTransition;
  
  TransitionManager$MultiListener(Transition paramTransition, ViewGroup paramViewGroup)
  {
    this.mTransition = paramTransition;
    this.mSceneRoot = paramViewGroup;
  }
  
  private void removeListeners()
  {
    this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
    this.mSceneRoot.removeOnAttachStateChangeListener(this);
  }
  
  public boolean onPreDraw()
  {
    removeListeners();
    if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
      return true;
    }
    ArrayMap localArrayMap = TransitionManager.getRunningTransitions();
    ArrayList localArrayList2 = (ArrayList)localArrayMap.get(this.mSceneRoot);
    ArrayList localArrayList1 = null;
    Object localObject;
    if (localArrayList2 == null)
    {
      localObject = new ArrayList();
      localArrayMap.put(this.mSceneRoot, localObject);
    }
    else
    {
      localObject = localArrayList2;
      if (localArrayList2.size() > 0)
      {
        localArrayList1 = new ArrayList(localArrayList2);
        localObject = localArrayList2;
      }
    }
    ((ArrayList)localObject).add(this.mTransition);
    this.mTransition.addListener(new TransitionManager.MultiListener.1(this, localArrayMap));
    this.mTransition.captureValues(this.mSceneRoot, false);
    if (localArrayList1 != null)
    {
      localObject = localArrayList1.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).resume(this.mSceneRoot);
      }
    }
    this.mTransition.playTransition(this.mSceneRoot);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    removeListeners();
    TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
    paramView = (ArrayList)TransitionManager.getRunningTransitions().get(this.mSceneRoot);
    if ((paramView != null) && (paramView.size() > 0))
    {
      paramView = paramView.iterator();
      while (paramView.hasNext()) {
        ((Transition)paramView.next()).resume(this.mSceneRoot);
      }
    }
    this.mTransition.clearValues(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.TransitionManager.MultiListener
 * JD-Core Version:    0.7.0.1
 */
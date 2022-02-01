package androidx.transition;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

class TransitionManager$MultiListener$1
  extends TransitionListenerAdapter
{
  TransitionManager$MultiListener$1(TransitionManager.MultiListener paramMultiListener, ArrayMap paramArrayMap) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    ((ArrayList)this.val$runningTransitions.get(this.this$0.mSceneRoot)).remove(paramTransition);
    paramTransition.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.TransitionManager.MultiListener.1
 * JD-Core Version:    0.7.0.1
 */
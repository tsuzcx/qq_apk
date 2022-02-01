package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class Visibility$1
  extends TransitionListenerAdapter
{
  Visibility$1(Visibility paramVisibility, ViewGroup paramViewGroup, View paramView1, View paramView2) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    this.val$startView.setTag(R.id.save_overlay_view, null);
    ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition)
  {
    ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
  }
  
  public void onTransitionResume(@NonNull Transition paramTransition)
  {
    if (this.val$finalOverlayView.getParent() == null)
    {
      ViewGroupUtils.getOverlay(this.val$overlayHost).add(this.val$finalOverlayView);
      return;
    }
    this.this$0.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Visibility.1
 * JD-Core Version:    0.7.0.1
 */
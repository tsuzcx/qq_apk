package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

class ChangeTransform$GhostListener
  extends TransitionListenerAdapter
{
  private GhostView mGhostView;
  private View mView;
  
  ChangeTransform$GhostListener(View paramView, GhostView paramGhostView)
  {
    this.mView = paramView;
    this.mGhostView = paramGhostView;
  }
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    paramTransition.removeListener(this);
    GhostViewUtils.removeGhost(this.mView);
    this.mView.setTag(R.id.transition_transform, null);
    this.mView.setTag(R.id.parent_matrix, null);
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition)
  {
    this.mGhostView.setVisibility(4);
  }
  
  public void onTransitionResume(@NonNull Transition paramTransition)
  {
    this.mGhostView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeTransform.GhostListener
 * JD-Core Version:    0.7.0.1
 */
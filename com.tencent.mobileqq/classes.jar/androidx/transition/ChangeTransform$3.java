package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;

class ChangeTransform$3
  extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;
  private Matrix mTempMatrix = new Matrix();
  
  ChangeTransform$3(ChangeTransform paramChangeTransform, boolean paramBoolean, Matrix paramMatrix, View paramView, ChangeTransform.Transforms paramTransforms, ChangeTransform.PathAnimatorMatrix paramPathAnimatorMatrix) {}
  
  private void setCurrentMatrix(Matrix paramMatrix)
  {
    this.mTempMatrix.set(paramMatrix);
    this.val$view.setTag(R.id.transition_transform, this.mTempMatrix);
    this.val$transforms.restore(this.val$view);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled) {
      if ((this.val$handleParentChange) && (this.this$0.mUseOverlay))
      {
        setCurrentMatrix(this.val$finalEndMatrix);
      }
      else
      {
        this.val$view.setTag(R.id.transition_transform, null);
        this.val$view.setTag(R.id.parent_matrix, null);
      }
    }
    ViewUtils.setAnimationMatrix(this.val$view, null);
    this.val$transforms.restore(this.val$view);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    setCurrentMatrix(this.val$pathAnimatorMatrix.getMatrix());
  }
  
  public void onAnimationResume(Animator paramAnimator)
  {
    ChangeTransform.setIdentityTransforms(this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeTransform.3
 * JD-Core Version:    0.7.0.1
 */
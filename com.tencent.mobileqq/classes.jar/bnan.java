import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;

public class bnan
  implements Animator.AnimatorListener
{
  public bnan(AECropperImageView paramAECropperImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    AECropperImageView.c(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnan
 * JD-Core Version:    0.7.0.1
 */
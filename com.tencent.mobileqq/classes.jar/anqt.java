import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class anqt
  extends AnimatorListenerAdapter
{
  public anqt(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.g();
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqt
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class anqy
  extends AnimatorListenerAdapter
{
  public anqy(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QIMCameraCaptureUnit.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqy
 * JD-Core Version:    0.7.0.1
 */
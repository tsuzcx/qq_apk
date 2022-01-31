import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.capture.view.WeiShiGuideView;

public class anqw
  extends AnimatorListenerAdapter
{
  public anqw(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QIMCameraCaptureUnit.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqw
 * JD-Core Version:    0.7.0.1
 */
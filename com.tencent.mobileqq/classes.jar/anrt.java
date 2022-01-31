import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anrt
  implements Animation.AnimationListener
{
  public anrt(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEffectCameraCaptureUnit", 2, "clearAnimation end!");
    }
    if (QIMEffectCameraCaptureUnit.d(this.a) == null) {
      return;
    }
    this.a.j = true;
    QIMEffectCameraCaptureUnit.d(this.a).setText(2131439129);
    QIMEffectCameraCaptureUnit.d(this.a).startAnimation(this.a.b);
    this.a.a.setStartOffset(3000L);
    this.a.a.setAnimationListener(QIMEffectCameraCaptureUnit.b(this.a));
    QIMEffectCameraCaptureUnit.d(this.a).setAnimation(this.a.a);
    this.a.a.startNow();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrt
 * JD-Core Version:    0.7.0.1
 */
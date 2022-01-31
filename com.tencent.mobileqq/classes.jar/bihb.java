import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class bihb
  implements Animation.AnimationListener
{
  public bihb(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEffectCameraCaptureUnit", 2, "clearAnimation end!");
    }
    if (QIMEffectCameraCaptureUnit.e(this.a) == null) {
      return;
    }
    this.a.v = true;
    QIMEffectCameraCaptureUnit.e(this.a).setText(2131699481);
    QIMEffectCameraCaptureUnit.e(this.a).startAnimation(this.a.b);
    this.a.a.setStartOffset(3000L);
    this.a.a.setAnimationListener(QIMEffectCameraCaptureUnit.b(this.a));
    QIMEffectCameraCaptureUnit.e(this.a).setAnimation(this.a.a);
    this.a.a.startNow();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.v = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihb
 * JD-Core Version:    0.7.0.1
 */
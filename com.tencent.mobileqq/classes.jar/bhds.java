import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class bhds
  implements Animation.AnimationListener
{
  public bhds(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMEffectCameraCaptureUnit.f(this.a) != null)
    {
      QIMEffectCameraCaptureUnit.f(this.a).clearAnimation();
      QIMEffectCameraCaptureUnit.f(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhds
 * JD-Core Version:    0.7.0.1
 */
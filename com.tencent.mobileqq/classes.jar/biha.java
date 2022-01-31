import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class biha
  implements Animation.AnimationListener
{
  public biha(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMEffectCameraCaptureUnit.e(this.a) != null)
    {
      QIMEffectCameraCaptureUnit.e(this.a).clearAnimation();
      QIMEffectCameraCaptureUnit.e(this.a).setVisibility(8);
    }
    this.a.v = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.v = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biha
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anrs
  implements Animation.AnimationListener
{
  public anrs(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMEffectCameraCaptureUnit.d(this.a) != null)
    {
      QIMEffectCameraCaptureUnit.d(this.a).clearAnimation();
      QIMEffectCameraCaptureUnit.d(this.a).setVisibility(8);
    }
    this.a.j = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrs
 * JD-Core Version:    0.7.0.1
 */
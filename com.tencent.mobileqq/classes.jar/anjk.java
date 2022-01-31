import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anjk
  implements Animation.AnimationListener
{
  public anjk(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMEffectCameraCaptureUnit.d(this.a) != null)
    {
      QIMEffectCameraCaptureUnit.d(this.a).clearAnimation();
      QIMEffectCameraCaptureUnit.d(this.a).setVisibility(8);
    }
    this.a.i = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anjk
 * JD-Core Version:    0.7.0.1
 */
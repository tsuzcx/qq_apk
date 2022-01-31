import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;

public class bhxn
  extends AnimatorListenerAdapter
{
  public bhxn(LightWeightCaptureButtonCornerLayout paramLightWeightCaptureButtonCornerLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.setTranslationY(0.0F);
    this.a.j();
    aquv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhxn
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout;

public class bmbk
  extends AnimatorListenerAdapter
{
  public bmbk(LightWeightCaptureButtonHorizontalLayout paramLightWeightCaptureButtonHorizontalLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.setTranslationX(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbk
 * JD-Core Version:    0.7.0.1
 */
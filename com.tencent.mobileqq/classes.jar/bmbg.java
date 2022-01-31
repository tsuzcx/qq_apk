import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;

public class bmbg
  extends AnimatorListenerAdapter
{
  public bmbg(LightWeightCaptureButtonCornerLayout paramLightWeightCaptureButtonCornerLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b.setTranslationY(0.0F);
    this.a.j();
    athi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbg
 * JD-Core Version:    0.7.0.1
 */
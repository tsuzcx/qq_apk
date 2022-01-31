import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MiniAppDialog.1.1;

public class bffu
  implements Animation.AnimationListener
{
  bffu(bfft parambfft) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bfft.a(this.a, false);
    bfft.a(this.a).post(new MiniAppDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bfft.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffu
 * JD-Core Version:    0.7.0.1
 */
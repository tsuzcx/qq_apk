import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MiniAppDialog.1.1;

public class bhhz
  implements Animation.AnimationListener
{
  bhhz(bhhy parambhhy) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bhhy.a(this.a, false);
    bhhy.a(this.a).post(new MiniAppDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bhhy.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhz
 * JD-Core Version:    0.7.0.1
 */
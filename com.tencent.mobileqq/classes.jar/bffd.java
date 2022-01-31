import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MiniAppDialog.1.1;

public class bffd
  implements Animation.AnimationListener
{
  bffd(bffc parambffc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bffc.a(this.a, false);
    bffc.a(this.a).post(new MiniAppDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bffc.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffd
 * JD-Core Version:    0.7.0.1
 */
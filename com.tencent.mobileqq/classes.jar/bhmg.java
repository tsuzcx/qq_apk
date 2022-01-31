import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.ui.MiniAppDialog.1.1;

public class bhmg
  implements Animation.AnimationListener
{
  bhmg(bhmf parambhmf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bhmf.a(this.a, false);
    bhmf.a(this.a).post(new MiniAppDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bhmf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmg
 * JD-Core Version:    0.7.0.1
 */
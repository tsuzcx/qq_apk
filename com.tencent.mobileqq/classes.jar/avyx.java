import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.onlinestatus.AccountPanel.3;

public class avyx
  implements Animation.AnimationListener
{
  public avyx(AccountPanel.3 param3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.this$0.dismiss();
      paramAnimation.setAnimationListener(null);
      avyo.a(this.a.this$0).clearAnimation();
      avyo.a(this.a.this$0, true);
      return;
    }
    catch (Exception paramAnimation)
    {
      for (;;)
      {
        paramAnimation.printStackTrace();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyx
 * JD-Core Version:    0.7.0.1
 */
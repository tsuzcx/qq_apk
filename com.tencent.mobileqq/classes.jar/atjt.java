import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.onlinestatus.AccountPanel.4;

public class atjt
  implements Animation.AnimationListener
{
  public atjt(AccountPanel.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.this$0.dismiss();
      paramAnimation.setAnimationListener(null);
      atjj.a(this.a.this$0).clearAnimation();
      atjj.a(this.a.this$0, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjt
 * JD-Core Version:    0.7.0.1
 */
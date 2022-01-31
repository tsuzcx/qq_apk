import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.core.widget.ActionSheetDialog.3;

public class bgmm
  implements Animation.AnimationListener
{
  public bgmm(ActionSheetDialog.3 param3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      bgml.a(this.a.this$0);
      bgml.a(this.a.this$0, true);
      return;
    }
    catch (Exception paramAnimation) {}
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmm
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class avan
  implements Animation.AnimationListener
{
  public avan(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ChooseInterestTagActivity.a(this.a).fullScroll(66);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avan
 * JD-Core Version:    0.7.0.1
 */
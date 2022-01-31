import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class atff
  implements Animation.AnimationListener
{
  public atff(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ChooseInterestTagActivity.a(this.a).fullScroll(66);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atff
 * JD-Core Version:    0.7.0.1
 */
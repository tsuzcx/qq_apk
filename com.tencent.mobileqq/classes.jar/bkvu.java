import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar;

public class bkvu
  implements Animation.AnimationListener
{
  public bkvu(BeautyBar paramBeautyBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bkpm.a("", "0X8007C05", BeautyBar.a(this.a) + "", "", "", "");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkvu
 * JD-Core Version:    0.7.0.1
 */
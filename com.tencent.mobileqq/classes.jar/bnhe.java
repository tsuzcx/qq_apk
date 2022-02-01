import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bnhe
  implements Animation.AnimationListener
{
  bnhe(bnhd parambnhd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bnhd.a(this.a) != null)
    {
      bnhd.a(this.a).clearAnimation();
      bnhd.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhe
 * JD-Core Version:    0.7.0.1
 */
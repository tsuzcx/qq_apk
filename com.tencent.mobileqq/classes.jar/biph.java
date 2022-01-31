import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class biph
  implements Animation.AnimationListener
{
  biph(bipg parambipg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bipg.a(this.a) != null)
    {
      bipg.a(this.a).clearAnimation();
      bipg.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biph
 * JD-Core Version:    0.7.0.1
 */
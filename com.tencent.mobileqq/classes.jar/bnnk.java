import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bnnk
  implements Animation.AnimationListener
{
  bnnk(bnnj parambnnj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bnnj.a(this.a) != null)
    {
      bnnj.a(this.a).clearAnimation();
      bnnj.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnk
 * JD-Core Version:    0.7.0.1
 */
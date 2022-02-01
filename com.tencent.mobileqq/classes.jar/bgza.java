import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

class bgza
  implements Animation.AnimationListener
{
  bgza(bgyz parambgyz) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(100L);
    this.a.a.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgza
 * JD-Core Version:    0.7.0.1
 */
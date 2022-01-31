import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bkyi
  implements Animation.AnimationListener
{
  bkyi(bkyh parambkyh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bkyh.a(this.a) != null)
    {
      bkyh.a(this.a).clearAnimation();
      bkyh.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyi
 * JD-Core Version:    0.7.0.1
 */
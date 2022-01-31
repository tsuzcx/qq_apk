import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bend
  implements Animation.AnimationListener
{
  bend(benb parambenb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    benb.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bend
 * JD-Core Version:    0.7.0.1
 */
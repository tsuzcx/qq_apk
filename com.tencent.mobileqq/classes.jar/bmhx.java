import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bmhx
  implements Animation.AnimationListener
{
  bmhx(bmhu parambmhu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bmhu.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhx
 * JD-Core Version:    0.7.0.1
 */
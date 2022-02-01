import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bnly
  implements Animation.AnimationListener
{
  bnly(bnlx parambnlx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bnlx.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnly
 * JD-Core Version:    0.7.0.1
 */
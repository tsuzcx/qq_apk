import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class bmpv
  implements Animation.AnimationListener
{
  bmpv(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpv
 * JD-Core Version:    0.7.0.1
 */
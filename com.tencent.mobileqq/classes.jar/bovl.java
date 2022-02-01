import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class bovl
  implements Animation.AnimationListener
{
  bovl(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovl
 * JD-Core Version:    0.7.0.1
 */
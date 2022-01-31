import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class anwt
  implements Animation.AnimationListener
{
  public anwt(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwt
 * JD-Core Version:    0.7.0.1
 */
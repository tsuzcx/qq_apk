import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class blbm
  implements Animation.AnimationListener
{
  blbm(blbl paramblbl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blbl.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbm
 * JD-Core Version:    0.7.0.1
 */
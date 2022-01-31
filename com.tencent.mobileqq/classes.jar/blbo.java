import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class blbo
  implements Animation.AnimationListener
{
  blbo(blbl paramblbl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blbl.a(this.a).setVisibility(8);
    blbl.a(this.a).setAlpha(1.0F);
    blbl.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbo
 * JD-Core Version:    0.7.0.1
 */
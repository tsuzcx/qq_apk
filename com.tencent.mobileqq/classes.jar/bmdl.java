import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bmdl
  implements Animation.AnimationListener
{
  bmdl(bmdi parambmdi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bmdi.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdl
 * JD-Core Version:    0.7.0.1
 */
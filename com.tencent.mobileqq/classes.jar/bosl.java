import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bosl
  implements Animation.AnimationListener
{
  bosl(bosi parambosi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bosi.a(this.a).setVisibility(8);
    bosi.a(this.a).setAlpha(1.0F);
    bosi.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosl
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class blwq
  implements Animation.AnimationListener
{
  blwq(blwn paramblwn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blwn.a(this.a).setVisibility(8);
    blwn.a(this.a).setAlpha(1.0F);
    blwn.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwq
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

class aofz
  implements Animation.AnimationListener
{
  aofz(aofw paramaofw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(500);
    paramAnimation.setFillAfter(true);
    paramAnimation.setAnimationListener(new aoga(this));
    this.a.g.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofz
 * JD-Core Version:    0.7.0.1
 */
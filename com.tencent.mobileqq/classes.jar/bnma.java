import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bnma
  implements Animation.AnimationListener
{
  bnma(bnlx parambnlx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bnlx.a(this.a).setVisibility(8);
    bnlx.a(this.a).setAlpha(1.0F);
    bnlx.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnma
 * JD-Core Version:    0.7.0.1
 */
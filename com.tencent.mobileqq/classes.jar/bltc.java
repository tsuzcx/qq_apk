import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bltc
  implements Animation.AnimationListener
{
  bltc(bltb parambltb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bltb.a(this.a) != null)
    {
      bltb.a(this.a).clearAnimation();
      bltb.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltc
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bkub
  implements Animation.AnimationListener
{
  bkub(bkua parambkua) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bkua.a(this.a) != null)
    {
      bkua.a(this.a).clearAnimation();
      bkua.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkub
 * JD-Core Version:    0.7.0.1
 */
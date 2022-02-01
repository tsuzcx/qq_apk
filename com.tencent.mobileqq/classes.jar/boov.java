import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class boov
  implements Animation.AnimationListener
{
  boov(boou paramboou) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (boou.a(this.a) != null)
    {
      boou.a(this.a).clearAnimation();
      boou.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boov
 * JD-Core Version:    0.7.0.1
 */
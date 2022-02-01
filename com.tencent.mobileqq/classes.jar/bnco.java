import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class bnco
  implements Animation.AnimationListener
{
  bnco(bncm parambncm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bncm.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnco
 * JD-Core Version:    0.7.0.1
 */
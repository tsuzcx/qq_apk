import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bioq
  implements Animation.AnimationListener
{
  bioq(biop parambiop) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (biop.a(this.a) != null)
    {
      biop.a(this.a).clearAnimation();
      biop.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bioq
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class boky
  implements Animation.AnimationListener
{
  boky(bokv parambokv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bokv.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boky
 * JD-Core Version:    0.7.0.1
 */
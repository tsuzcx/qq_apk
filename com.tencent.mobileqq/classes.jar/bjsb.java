import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bjsb
  implements Animation.AnimationListener
{
  bjsb(bjry parambjry) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bjry.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsb
 * JD-Core Version:    0.7.0.1
 */
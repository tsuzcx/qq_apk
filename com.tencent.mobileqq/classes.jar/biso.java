import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class biso
  implements Animation.AnimationListener
{
  biso(bisl parambisl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bisl.a(this.a).setVisibility(8);
    bisl.a(this.a).setAlpha(1.0F);
    bisl.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biso
 * JD-Core Version:    0.7.0.1
 */
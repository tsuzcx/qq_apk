import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class bjec
  implements Animation.AnimationListener
{
  bjec(View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new bjcp(this.a);
    paramAnimation.setDuration(bjeb.a());
    paramAnimation.setFillAfter(true);
    this.a.startAnimation(paramAnimation);
    this.a.setVisibility(0);
    this.b.clearAnimation();
    this.b.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.clearAnimation();
    this.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjec
 * JD-Core Version:    0.7.0.1
 */
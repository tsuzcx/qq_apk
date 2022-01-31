import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class berx
  implements Animation.AnimationListener
{
  berx(View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new beqk(this.a);
    paramAnimation.setDuration(berw.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berx
 * JD-Core Version:    0.7.0.1
 */
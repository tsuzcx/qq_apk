import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class bcrz
  implements Animation.AnimationListener
{
  bcrz(View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new bcqm(this.a);
    paramAnimation.setDuration(bcry.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcrz
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bkxh
  implements Animation.AnimationListener
{
  bkxh(bkxe parambkxe) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bkxe.a(this.a).setVisibility(8);
    bkxe.a(this.a).setAlpha(1.0F);
    bkxe.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxh
 * JD-Core Version:    0.7.0.1
 */
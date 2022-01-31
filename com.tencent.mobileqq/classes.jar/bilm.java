import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bilm
  implements Animation.AnimationListener
{
  bilm(bilj parambilj) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((bilj.a(this.a) != null) && (!bilj.a(this.a)))
    {
      bilj.a(this.a).setAlpha(1.0F);
      bilj.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilm
 * JD-Core Version:    0.7.0.1
 */
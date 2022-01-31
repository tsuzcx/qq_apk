import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bimd
  implements Animation.AnimationListener
{
  bimd(bima parambima) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((bima.a(this.a) != null) && (!bima.a(this.a)))
    {
      bima.a(this.a).setAlpha(1.0F);
      bima.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimd
 * JD-Core Version:    0.7.0.1
 */
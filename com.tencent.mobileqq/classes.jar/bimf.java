import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bimf
  implements Animation.AnimationListener
{
  bimf(bima parambima) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bima.a(this.a) != null) && (!bima.a(this.a)))
    {
      bima.a(this.a).setAlpha(1.0F);
      bima.a(this.a).setVisibility(4);
    }
    if (bima.b(this.a) != null)
    {
      bima.c(this.a).a(327683, new Object[0]);
      bima.d(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bima.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimf
 * JD-Core Version:    0.7.0.1
 */
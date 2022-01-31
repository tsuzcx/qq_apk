import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bimh
  implements Animation.AnimationListener
{
  bimh(bima parambima) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bima.a(this.a) != null) && (!bima.a(this.a)))
    {
      bima.a(this.a).setAlpha(1.0F);
      bima.a(this.a).setVisibility(4);
    }
    if (bima.e(this.a) != null)
    {
      bima.f(this.a).a(327684, new Object[0]);
      bima.g(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bima.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimh
 * JD-Core Version:    0.7.0.1
 */
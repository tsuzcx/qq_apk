import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bkve
  implements Animation.AnimationListener
{
  bkve(bkuy parambkuy) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bkuy.a(this.a) != null) && (!bkuy.a(this.a)))
    {
      bkuy.a(this.a).setAlpha(1.0F);
      bkuy.a(this.a).setVisibility(4);
    }
    if (bkuy.e(this.a) != null)
    {
      bkuy.f(this.a).a(327684, new Object[0]);
      bkuy.g(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkuy.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkve
 * JD-Core Version:    0.7.0.1
 */
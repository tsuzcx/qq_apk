import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bkqv
  implements Animation.AnimationListener
{
  bkqv(bkqr parambkqr) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bkqr.a(this.a) != null) && (!bkqr.a(this.a)))
    {
      bkqr.a(this.a).setAlpha(1.0F);
      bkqr.a(this.a).setVisibility(4);
    }
    if (bkqr.b(this.a) != null)
    {
      bkqr.c(this.a).a(327683, new Object[0]);
      bkqr.d(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkqr.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqv
 * JD-Core Version:    0.7.0.1
 */
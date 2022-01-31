import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bkvc
  implements Animation.AnimationListener
{
  bkvc(bkuy parambkuy) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bkuy.a(this.a) != null) && (!bkuy.a(this.a)))
    {
      bkuy.a(this.a).setAlpha(1.0F);
      bkuy.a(this.a).setVisibility(4);
    }
    if (bkuy.b(this.a) != null)
    {
      bkuy.c(this.a).a(327683, new Object[0]);
      bkuy.d(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkuy.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvc
 * JD-Core Version:    0.7.0.1
 */
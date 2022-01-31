import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bilo
  implements Animation.AnimationListener
{
  bilo(bilj parambilj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bilj.a(this.a) != null) && (!bilj.a(this.a)))
    {
      bilj.a(this.a).setAlpha(1.0F);
      bilj.a(this.a).setVisibility(4);
    }
    if (bilj.b(this.a) != null)
    {
      bilj.c(this.a).a(327683, new Object[0]);
      bilj.d(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bilj.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilo
 * JD-Core Version:    0.7.0.1
 */
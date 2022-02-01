import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bnkh
  implements Animation.AnimationListener
{
  bnkh(bnkd parambnkd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((bnkd.a(this.a) != null) && (!bnkd.a(this.a)))
    {
      bnkd.a(this.a).setAlpha(1.0F);
      bnkd.a(this.a).setVisibility(4);
    }
    if (bnkd.b(this.a) != null)
    {
      bnkd.c(this.a).a(327683, new Object[0]);
      bnkd.d(this.a).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bnkd.a(this.a).a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkh
 * JD-Core Version:    0.7.0.1
 */
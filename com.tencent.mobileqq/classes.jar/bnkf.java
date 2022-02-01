import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bnkf
  implements Animation.AnimationListener
{
  bnkf(bnkd parambnkd) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((bnkd.a(this.a) != null) && (bnkd.b(this.a)))
    {
      bnkd.a(this.a).setAlpha(1.0F);
      bnkd.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkf
 * JD-Core Version:    0.7.0.1
 */
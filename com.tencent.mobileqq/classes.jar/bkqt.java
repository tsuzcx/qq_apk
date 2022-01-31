import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bkqt
  implements Animation.AnimationListener
{
  bkqt(bkqr parambkqr) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((bkqr.a(this.a) != null) && (bkqr.b(this.a)))
    {
      bkqr.a(this.a).setAlpha(1.0F);
      bkqr.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqt
 * JD-Core Version:    0.7.0.1
 */
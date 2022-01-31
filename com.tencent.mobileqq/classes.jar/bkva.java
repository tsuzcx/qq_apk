import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bkva
  implements Animation.AnimationListener
{
  bkva(bkuy parambkuy) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((bkuy.a(this.a) != null) && (bkuy.b(this.a)))
    {
      bkuy.a(this.a).setAlpha(1.0F);
      bkuy.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkva
 * JD-Core Version:    0.7.0.1
 */
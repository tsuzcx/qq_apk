import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bolr
  implements Animation.AnimationListener
{
  bolr(boll paramboll) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.a != null) && (boll.b(this.a)))
    {
      this.a.a.setAlpha(1.0F);
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolr
 * JD-Core Version:    0.7.0.1
 */
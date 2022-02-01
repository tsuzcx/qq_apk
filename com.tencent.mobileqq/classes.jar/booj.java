import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class booj
  implements Animation.AnimationListener
{
  public booj(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booj
 * JD-Core Version:    0.7.0.1
 */
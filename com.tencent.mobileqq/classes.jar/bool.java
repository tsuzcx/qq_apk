import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class bool
  implements Animation.AnimationListener
{
  public bool(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setAlpha(1.0F);
    this.a.setVisibility(8);
    if (AEProviderContainerView.a(this.a) != null) {
      AEProviderContainerView.a(this.a).a(false, 150);
    }
    if (AEProviderContainerView.a(this.a) != null) {
      AEProviderContainerView.a(this.a).a(131075, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bool
 * JD-Core Version:    0.7.0.1
 */
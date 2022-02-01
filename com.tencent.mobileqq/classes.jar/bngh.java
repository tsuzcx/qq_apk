import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkProviderView;

public class bngh
  implements Animation.AnimationListener
{
  public bngh(AEWaterMarkPanel paramAEWaterMarkPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null)
    {
      this.a.a.setAlpha(1.0F);
      this.a.a.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngh
 * JD-Core Version:    0.7.0.1
 */
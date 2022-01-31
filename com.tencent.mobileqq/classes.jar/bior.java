import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView;

public class bior
  implements Animation.AnimationListener
{
  public bior(AEMaterialPanel paramAEMaterialPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AEMaterialPanel.a(this.a) != null)
    {
      AEMaterialPanel.a(this.a).setAlpha(1.0F);
      AEMaterialPanel.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bior
 * JD-Core Version:    0.7.0.1
 */
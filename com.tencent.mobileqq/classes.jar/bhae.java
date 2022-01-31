import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.qq.im.AECamera.panel.material.AEMaterialProviderView;

public class bhae
  implements Animation.AnimationListener
{
  public bhae(AEMaterialPanel paramAEMaterialPanel) {}
  
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
 * Qualified Name:     bhae
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView;

public class bkxq
  implements Animation.AnimationListener
{
  public bkxq(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).b();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, true);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel) != null)
    {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).setAlpha(1.0F);
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxq
 * JD-Core Version:    0.7.0.1
 */
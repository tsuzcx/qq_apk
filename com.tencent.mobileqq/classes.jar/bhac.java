import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.qq.im.AECamera.panel.material.AEMaterialProviderView;

public class bhac
  implements Animation.AnimationListener
{
  public bhac(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel).b();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel, true);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel) != null)
    {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel).setAlpha(1.0F);
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhac
 * JD-Core Version:    0.7.0.1
 */
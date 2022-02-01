import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkProviderView;

public class bngk
  implements Animation.AnimationListener
{
  public bngk(AEWaterMarkPanel paramAEWaterMarkPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEWaterMarkPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel, true);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.setVisibility(0);
      bnqm.a().at();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a.a();
      return;
    }
    bnrh.d("AEWaterMarkPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngk
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

public class bood
  implements Animator.AnimatorListener
{
  public bood(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel).c();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bood
 * JD-Core Version:    0.7.0.1
 */
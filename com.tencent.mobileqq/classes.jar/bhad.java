import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;

public class bhad
  implements Animator.AnimatorListener
{
  public bhad(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel).c();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhad
 * JD-Core Version:    0.7.0.1
 */
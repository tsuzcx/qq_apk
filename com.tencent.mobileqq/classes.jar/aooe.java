import android.animation.Animator;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPlusPanel;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;

public class aooe
  extends aooa
{
  public aooe(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationEnd <<===");
    }
    if (this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowPlusPanel != null) {
      this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowPlusPanel.a();
    }
    this.a.k();
    this.a.e.setVisibility(4);
    this.a.e.setPadding(0, 0, 0, 0);
    if ((this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null)) {
      this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.y();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "startExitPtvModeAnimation: onAnimationStart ===>>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aooe
 * JD-Core Version:    0.7.0.1
 */
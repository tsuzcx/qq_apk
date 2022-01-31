import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPlusPanel;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;

public class anpo
  extends anpd
{
  public anpo(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterPtvModeAnimation: onAnimationEnd <<===");
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.x();
    this.a.m();
    if (!this.a.g) {
      this.a.e(false);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "enterPtvModeAnimation: onAnimationStart ===>>");
    }
    this.a.e.setVisibility(0);
    this.a.f.setBackgroundColor(this.a.getResources().getColor(2131493274));
    this.a.d = true;
    if (this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowPlusPanel != null) {
      this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowPlusPanel.b();
    }
    if (this.a.g)
    {
      this.a.b.setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.a.b.setLongClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpo
 * JD-Core Version:    0.7.0.1
 */
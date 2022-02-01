import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class awny
  implements biwp
{
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  boolean jdField_a_of_type_Boolean = false;
  
  awny(awnx paramawnx, awit paramawit) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Awnx.a.isBackgroundPause) || (this.jdField_a_of_type_Awnx.a.isBackgroundStop)) {
      awnx.a(this.jdField_a_of_type_Awnx, this.jdField_a_of_type_Awnx.a, this.jdField_a_of_type_Awit);
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = awju.a(this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new awnz(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      LocationShareFragment.a(localBaseActivity, this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a(), 4);
    }
    awnk.d();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awny
 * JD-Core Version:    0.7.0.1
 */
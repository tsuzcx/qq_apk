import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class awup
  implements bjft
{
  bhpc jdField_a_of_type_Bhpc;
  boolean jdField_a_of_type_Boolean = false;
  
  awup(awuo paramawuo, BaseActivity paramBaseActivity, awpk paramawpk) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Awuo.a.isBackgroundPause) || (this.jdField_a_of_type_Awuo.a.isBackgroundStop)) {
      awuo.a(this.jdField_a_of_type_Awuo, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awpk);
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bhpc = awql.a(this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bhpc != null) {
          this.jdField_a_of_type_Bhpc.setOnDismissListener(new awuq(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a(), 4);
    awub.d();
    if (this.jdField_a_of_type_Bhpc != null) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awup
 * JD-Core Version:    0.7.0.1
 */
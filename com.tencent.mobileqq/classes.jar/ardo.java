import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class ardo
  implements bbqq
{
  bafb jdField_a_of_type_Bafb;
  boolean jdField_a_of_type_Boolean = false;
  
  ardo(ardn paramardn, BaseActivity paramBaseActivity, aqyw paramaqyw) {}
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bafb = aqzw.a(this.jdField_a_of_type_Aqyw.a(), this.jdField_a_of_type_Aqyw.a());
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bafb != null) {
        this.jdField_a_of_type_Bafb.setOnDismissListener(new ardp(this));
      }
    }
    awqx.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aqyw.a(), this.jdField_a_of_type_Aqyw.a(), 4);
    ardg.e();
    if (this.jdField_a_of_type_Bafb != null) {}
    try
    {
      this.jdField_a_of_type_Bafb.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ardo
 * JD-Core Version:    0.7.0.1
 */
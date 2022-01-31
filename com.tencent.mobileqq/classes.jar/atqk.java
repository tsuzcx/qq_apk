import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class atqk
  implements betn
{
  bdfq jdField_a_of_type_Bdfq;
  boolean jdField_a_of_type_Boolean = false;
  
  atqk(atqj paramatqj, BaseActivity paramBaseActivity, atlh paramatlh) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Atqj.a.isBackground_Pause) || (this.jdField_a_of_type_Atqj.a.isBackground_Stop)) {
      atqj.a(this.jdField_a_of_type_Atqj, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atlh);
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdfq = atmi.a(this.jdField_a_of_type_Atlh.a(), this.jdField_a_of_type_Atlh.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bdfq != null) {
          this.jdField_a_of_type_Bdfq.setOnDismissListener(new atql(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atlh.a(), this.jdField_a_of_type_Atlh.a(), 4);
    atpw.e();
    if (this.jdField_a_of_type_Bdfq != null) {}
    try
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqk
 * JD-Core Version:    0.7.0.1
 */
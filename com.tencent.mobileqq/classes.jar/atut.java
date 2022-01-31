import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class atut
  implements bexw
{
  bdjz jdField_a_of_type_Bdjz;
  boolean jdField_a_of_type_Boolean = false;
  
  atut(atus paramatus, BaseActivity paramBaseActivity, atpq paramatpq) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Atus.a.isBackground_Pause) || (this.jdField_a_of_type_Atus.a.isBackground_Stop)) {
      atus.a(this.jdField_a_of_type_Atus, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atpq);
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdjz = atqr.a(this.jdField_a_of_type_Atpq.a(), this.jdField_a_of_type_Atpq.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bdjz != null) {
          this.jdField_a_of_type_Bdjz.setOnDismissListener(new atuu(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atpq.a(), this.jdField_a_of_type_Atpq.a(), 4);
    atuf.e();
    if (this.jdField_a_of_type_Bdjz != null) {}
    try
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atut
 * JD-Core Version:    0.7.0.1
 */
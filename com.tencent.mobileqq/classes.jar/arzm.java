import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class arzm
  implements bctp
{
  bbgg jdField_a_of_type_Bbgg;
  boolean jdField_a_of_type_Boolean = false;
  
  arzm(arzl paramarzl, BaseActivity paramBaseActivity, aruk paramaruk) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Arzl.a.isBackground_Pause) || (this.jdField_a_of_type_Arzl.a.isBackground_Stop)) {
      arzl.a(this.jdField_a_of_type_Arzl, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aruk);
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bbgg = arvk.a(this.jdField_a_of_type_Aruk.a(), this.jdField_a_of_type_Aruk.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bbgg != null) {
          this.jdField_a_of_type_Bbgg.setOnDismissListener(new arzn(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aruk.a(), this.jdField_a_of_type_Aruk.a(), 4);
    aryy.e();
    if (this.jdField_a_of_type_Bbgg != null) {}
    try
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzm
 * JD-Core Version:    0.7.0.1
 */
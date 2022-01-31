import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class arzo
  implements bcue
{
  bbgu jdField_a_of_type_Bbgu;
  boolean jdField_a_of_type_Boolean = false;
  
  arzo(arzn paramarzn, BaseActivity paramBaseActivity, arum paramarum) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Arzn.a.isBackground_Pause) || (this.jdField_a_of_type_Arzn.a.isBackground_Stop)) {
      arzn.a(this.jdField_a_of_type_Arzn, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Arum);
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bbgu = arvm.a(this.jdField_a_of_type_Arum.a(), this.jdField_a_of_type_Arum.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bbgu != null) {
          this.jdField_a_of_type_Bbgu.setOnDismissListener(new arzp(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Arum.a(), this.jdField_a_of_type_Arum.a(), 4);
    arza.e();
    if (this.jdField_a_of_type_Bbgu != null) {}
    try
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzo
 * JD-Core Version:    0.7.0.1
 */
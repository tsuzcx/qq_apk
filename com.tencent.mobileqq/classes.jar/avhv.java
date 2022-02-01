import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class avhv
  implements bhlz
{
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  boolean jdField_a_of_type_Boolean = false;
  
  avhv(avhu paramavhu, BaseActivity paramBaseActivity, avcq paramavcq) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Avhu.a.isBackgroundPause) || (this.jdField_a_of_type_Avhu.a.isBackgroundStop)) {
      avhu.a(this.jdField_a_of_type_Avhu, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Avcq);
    }
    for (;;)
    {
      bcef.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = avdr.a(this.jdField_a_of_type_Avcq.a(), this.jdField_a_of_type_Avcq.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new avhw(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Avcq.a(), this.jdField_a_of_type_Avcq.a(), 4);
    avhh.d();
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
 * Qualified Name:     avhv
 * JD-Core Version:    0.7.0.1
 */
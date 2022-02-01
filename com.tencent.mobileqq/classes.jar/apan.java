import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class apan
  implements QQPermissionCallback
{
  apan(apam paramapam, BaseActivity paramBaseActivity, apak paramapak) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    apam.a(this.jdField_a_of_type_Apam, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Apak);
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, grant");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apan
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class amnd
  implements QQPermissionCallback
{
  amnd(amnc paramamnc, BaseActivity paramBaseActivity, amna paramamna) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    amnc.a(this.jdField_a_of_type_Amnc, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Amna);
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, grant");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnd
 * JD-Core Version:    0.7.0.1
 */
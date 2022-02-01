import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class apdz
  implements QQPermissionCallback
{
  apdz(apdy paramapdy, BaseActivity paramBaseActivity, apdw paramapdw) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    apdy.a(this.jdField_a_of_type_Apdy, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Apdw);
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, grant");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdz
 * JD-Core Version:    0.7.0.1
 */
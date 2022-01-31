import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class awcz
  implements QQPermissionCallback
{
  public awcz(SignTextEditFragment paramSignTextEditFragment, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user denied");
    }
    bbdj.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user grant");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignTextEditFragment.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awcz
 * JD-Core Version:    0.7.0.1
 */
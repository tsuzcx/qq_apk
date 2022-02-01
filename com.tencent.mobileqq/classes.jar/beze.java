import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public final class beze
  implements QQPermissionCallback
{
  public beze(bezj parambezj, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Bezj.a(bgip.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AppConstants.SDCARD_IMG_SAVE, 1001));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beze
 * JD-Core Version:    0.7.0.1
 */
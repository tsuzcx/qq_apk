import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public final class bfjk
  implements QQPermissionCallback
{
  public bfjk(bfjp parambfjp, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Bfjp.a(bgqv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, antf.bg, 1001));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjk
 * JD-Core Version:    0.7.0.1
 */
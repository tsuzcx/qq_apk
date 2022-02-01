import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.QQPermissionCallback;

public class awlb
  implements QQPermissionCallback
{
  public awlb(LocationPickFragment paramLocationPickFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).setOnDismissListener(new awlc(this));
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = awiz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    paramArrayOfInt.a(paramInt, paramArrayOfString, paramArrayOfInt.a(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlb
 * JD-Core Version:    0.7.0.1
 */
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import mqq.app.QQPermissionCallback;

public class atnn
  implements QQPermissionCallback
{
  public atnn(LocationPickFragment paramLocationPickFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new atno(this));
    }
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = atln.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    paramArrayOfInt.a(paramInt, paramArrayOfString, paramArrayOfInt.a(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnn
 * JD-Core Version:    0.7.0.1
 */
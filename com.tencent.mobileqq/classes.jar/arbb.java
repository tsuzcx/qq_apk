import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import mqq.app.QQPermissionCallback;

public class arbb
  implements QQPermissionCallback
{
  public arbb(LocationPickFragment paramLocationPickFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new arbc(this));
    }
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    paramArrayOfInt.a(paramInt, paramArrayOfString, paramArrayOfInt.a(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbb
 * JD-Core Version:    0.7.0.1
 */
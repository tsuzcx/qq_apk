import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import mqq.app.QQPermissionCallback;

public class atrw
  implements QQPermissionCallback
{
  public atrw(LocationPickFragment paramLocationPickFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new atrx(this));
    }
    paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = atpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    paramArrayOfInt.a(paramInt, paramArrayOfString, paramArrayOfInt.a(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */
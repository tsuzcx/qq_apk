import android.app.Dialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import mqq.app.QQPermissionCallback;

public class atti
  implements QQPermissionCallback
{
  public atti(LocationShareFragment paramLocationShareFragment, BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new attj(this));
    }
    atpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atti
 * JD-Core Version:    0.7.0.1
 */
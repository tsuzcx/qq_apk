import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import mqq.app.QQPermissionCallback;

public class azvl
  implements QQPermissionCallback
{
  public azvl(CustomCoverFragment paramCustomCoverFragment, FragmentActivity paramFragmentActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CustomCoverFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvl
 * JD-Core Version:    0.7.0.1
 */
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import mqq.app.QQPermissionCallback;

public class ayka
  implements QQPermissionCallback
{
  public ayka(CustomCoverFragment paramCustomCoverFragment, FragmentActivity paramFragmentActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CustomCoverFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayka
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class arle
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  public arle(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onGlobalLayout()
  {
    ExtendFriendProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = ExtendFriendProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).getRootView().getHeight();
      int k = j - i;
      if (k <= j / 4) {
        break label90;
      }
      ExtendFriendProfileEditFragment.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment, k);
      this.jdField_a_of_type_Boolean = true;
      ExtendFriendProfileEditFragment.d(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label90:
      if (this.jdField_a_of_type_Boolean) {
        ExtendFriendProfileEditFragment.e(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arle
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;

public class anrs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public anrs(ExtendFriendSearchFragment paramExtendFriendSearchFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment.e = localObject[1];
    localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment;
    ((ExtendFriendSearchFragment)localObject).e += this.jdField_a_of_type_AndroidViewView.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anrs
 * JD-Core Version:    0.7.0.1
 */
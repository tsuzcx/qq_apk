import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class aqau
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aqau(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.e = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqau
 * JD-Core Version:    0.7.0.1
 */
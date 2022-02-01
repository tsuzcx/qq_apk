import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;

public class arkc
  implements View.OnTouchListener
{
  public arkc(ExtendFriendCampusFragment paramExtendFriendCampusFragment, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidViewView.postInvalidate();
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidViewView.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkc
 * JD-Core Version:    0.7.0.1
 */
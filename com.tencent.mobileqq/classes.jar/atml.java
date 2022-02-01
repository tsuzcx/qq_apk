import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class atml
  implements View.OnTouchListener
{
  public atml(ForwardFileOption paramForwardFileOption, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(25, 0, 0, 0));
      }
    }
    while ((paramMotionEvent.getAction() != 1) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(0, 0, 0, 0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atml
 * JD-Core Version:    0.7.0.1
 */
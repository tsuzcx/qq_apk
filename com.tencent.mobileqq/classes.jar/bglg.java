import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class bglg
  implements View.OnTouchListener
{
  public bglg(Login paramLogin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.a.jdField_b_of_type_AndroidWidgetEditText) {
      if ((paramMotionEvent.getAction() == 0) && (this.a.jdField_b_of_type_AndroidWidgetEditText.getText().length() > 0)) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((paramView != this.a.jdField_a_of_type_AndroidWidgetEditText) || (paramMotionEvent.getAction() != 0) || (this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)) {
      return false;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglg
 * JD-Core Version:    0.7.0.1
 */
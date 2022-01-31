import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

class beno
  implements View.OnTouchListener
{
  beno(benn parambenn, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      betc.a("QQToast", "start to cancel toast");
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      benn.a(this.jdField_a_of_type_Benn, true);
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        bool = this.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beno
 * JD-Core Version:    0.7.0.1
 */
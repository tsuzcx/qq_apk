import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

class bbmz
  implements View.OnTouchListener
{
  bbmz(bbmy parambbmy, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "start to cancel toast");
      }
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      bbmy.a(this.jdField_a_of_type_Bbmy, true);
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        bool = this.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbmz
 * JD-Core Version:    0.7.0.1
 */
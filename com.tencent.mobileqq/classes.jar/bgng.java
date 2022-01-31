import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.log.QMLog;

class bgng
  implements View.OnTouchListener
{
  bgng(bgnf parambgnf, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      QMLog.d("QQToast", "start to cancel toast");
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      bgnf.a(this.jdField_a_of_type_Bgnf, true);
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        bool = this.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgng
 * JD-Core Version:    0.7.0.1
 */
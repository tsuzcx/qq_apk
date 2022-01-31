import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.log.QMLog;

class bgrn
  implements View.OnTouchListener
{
  bgrn(bgrm parambgrm, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      QMLog.d("QQToast", "start to cancel toast");
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      bgrm.a(this.jdField_a_of_type_Bgrm, true);
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        bool = this.jdField_a_of_type_AndroidViewView$OnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrn
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.qq.im.poi.LbsPackPoiListActivity;

public class anh
  implements View.OnTouchListener
{
  public anh(LbsPackPoiListActivity paramLbsPackPoiListActivity, InputMethodManager paramInputMethodManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anh
 * JD-Core Version:    0.7.0.1
 */
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class aykd
  implements View.OnTouchListener
{
  public aykd(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykd
 * JD-Core Version:    0.7.0.1
 */
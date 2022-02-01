import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class atqy
  implements View.OnTouchListener
{
  public atqy(FileSelectorSearchGroupFragment paramFileSelectorSearchGroupFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqy
 * JD-Core Version:    0.7.0.1
 */
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;

public class ayev
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ayev(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onGlobalLayout()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      this.a.a.requestFocus();
      localInputMethodManager.showSoftInput(this.a.a, 0);
    }
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayev
 * JD-Core Version:    0.7.0.1
 */
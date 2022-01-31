import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class awlo
  implements View.OnTouchListener
{
  public awlo(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!awvy.a(SelectMemberContactSearchFragment.a(this.a))) && (!SelectMemberContactSearchFragment.a(this.a)) && (paramMotionEvent.getAction() == 1))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
      return false;
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlo
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;

public class ayes
  implements View.OnClickListener
{
  public ayes(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    this.a.a.requestFocus();
    paramView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (paramView != null) {
      paramView.showSoftInput(this.a.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayes
 * JD-Core Version:    0.7.0.1
 */
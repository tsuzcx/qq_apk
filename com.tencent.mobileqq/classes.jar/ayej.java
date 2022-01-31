import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class ayej
  implements View.OnClickListener
{
  public ayej(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayej
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcak
  implements View.OnClickListener
{
  public bcak(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcak
 * JD-Core Version:    0.7.0.1
 */
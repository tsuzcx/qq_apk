import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class batt
  implements View.OnClickListener
{
  public batt(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    BaseSearchActivity.b = 1;
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batt
 * JD-Core Version:    0.7.0.1
 */
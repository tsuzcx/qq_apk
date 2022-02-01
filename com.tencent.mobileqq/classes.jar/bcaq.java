import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcaq
  implements View.OnClickListener
{
  public bcaq(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaq
 * JD-Core Version:    0.7.0.1
 */
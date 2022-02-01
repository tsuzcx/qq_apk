import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqib
  implements View.OnClickListener
{
  public aqib(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqib
 * JD-Core Version:    0.7.0.1
 */
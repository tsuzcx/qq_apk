import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnh
  implements View.OnClickListener
{
  public aqnh(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnh
 * JD-Core Version:    0.7.0.1
 */
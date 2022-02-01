import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqyb
  implements View.OnClickListener
{
  public aqyb(TimeSelectView paramTimeSelectView) {}
  
  public void onClick(View paramView)
  {
    if (TimeSelectView.a(this.a) != null) {
      TimeSelectView.a(this.a).a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyb
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqup
  implements View.OnClickListener
{
  public aqup(TimeSelectView paramTimeSelectView) {}
  
  public void onClick(View paramView)
  {
    if (TimeSelectView.a(this.a) != null) {
      TimeSelectView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqup
 * JD-Core Version:    0.7.0.1
 */
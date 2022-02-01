import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.widget.LocationDetailActivity;

public class bmcb
  implements View.OnClickListener
{
  public bmcb(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcb
 * JD-Core Version:    0.7.0.1
 */
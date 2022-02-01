import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.widget.LocationDetailActivity;

public class bmca
  implements View.OnClickListener
{
  public bmca(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    LocationDetailActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmca
 * JD-Core Version:    0.7.0.1
 */
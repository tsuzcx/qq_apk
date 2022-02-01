import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.widget.LocationDetailActivity;

public class bmby
  implements View.OnClickListener
{
  public bmby(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmby
 * JD-Core Version:    0.7.0.1
 */
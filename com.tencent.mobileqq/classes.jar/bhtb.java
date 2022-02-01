import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhtb
  implements View.OnClickListener
{
  public bhtb(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtb
 * JD-Core Version:    0.7.0.1
 */
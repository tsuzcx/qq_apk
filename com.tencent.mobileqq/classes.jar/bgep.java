import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgep
  implements View.OnClickListener
{
  public bgep(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  public void onClick(View paramView)
  {
    BulkSendMessageFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgep
 * JD-Core Version:    0.7.0.1
 */
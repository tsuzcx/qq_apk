import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awnb
  implements View.OnClickListener
{
  public awnb(RecentUserInvitePanel paramRecentUserInvitePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnb
 * JD-Core Version:    0.7.0.1
 */
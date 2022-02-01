import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axzt
  implements View.OnClickListener
{
  public axzt(RecentUserInvitePanel paramRecentUserInvitePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzt
 * JD-Core Version:    0.7.0.1
 */
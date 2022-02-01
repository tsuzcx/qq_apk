import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axtd
  implements View.OnClickListener
{
  public axtd(RecentUserInvitePanel paramRecentUserInvitePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtd
 * JD-Core Version:    0.7.0.1
 */
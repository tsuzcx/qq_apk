import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awna
  implements View.OnClickListener
{
  public awna(RecentUserInvitePanel paramRecentUserInvitePanel, awnf paramawnf) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a.a(paramView, this.jdField_a_of_type_Awnf);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awna
 * JD-Core Version:    0.7.0.1
 */
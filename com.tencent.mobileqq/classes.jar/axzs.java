import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axzs
  implements View.OnClickListener
{
  public axzs(RecentUserInvitePanel paramRecentUserInvitePanel, axzx paramaxzx) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a.a(paramView, this.jdField_a_of_type_Axzx);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzs
 * JD-Core Version:    0.7.0.1
 */
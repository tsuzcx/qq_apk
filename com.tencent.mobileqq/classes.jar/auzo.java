import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel;

public class auzo
  implements View.OnClickListener
{
  public auzo(PlayerInvitePanel paramPlayerInvitePanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PlayerInvitePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel) != null) {
      PlayerInvitePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel).onItemClick(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auzo
 * JD-Core Version:    0.7.0.1
 */
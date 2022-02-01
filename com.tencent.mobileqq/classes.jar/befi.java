import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class befi
  implements View.OnClickListener
{
  public befi(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).notifyDataSetChanged();
    bhhr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getCurrentUin(), 1, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befi
 * JD-Core Version:    0.7.0.1
 */
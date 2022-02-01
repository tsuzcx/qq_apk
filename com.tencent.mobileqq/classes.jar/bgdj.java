import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgdj
  implements View.OnClickListener
{
  public bgdj(VisitorTroopCardFragment paramVisitorTroopCardFragment, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.isOwnerOrAdim())
    {
      bhbu.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_cancel", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.troopUin });
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdj
 * JD-Core Version:    0.7.0.1
 */
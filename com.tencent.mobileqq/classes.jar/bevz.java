import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;

public class bevz
  implements bjoe
{
  public bevz(VisitorTroopCardFragment paramVisitorTroopCardFragment, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) == null) {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, new bhhw(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity()));
    }
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity()))
    {
      paramView = (anca)this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
      if (paramView != null)
      {
        if ((VisitorTroopCardFragment.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) & 0x1) == 0)
        {
          VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, VisitorTroopCardFragment.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) | 0x1);
          paramView.l(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(0, 2131691949, 1000);
      }
    }
    for (;;)
    {
      bewt.a(21, new Object());
      this.jdField_a_of_type_Bjnw.cancel();
      return;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131691945, 1500);
      continue;
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131694108, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bevz
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class bgdl
  implements bkzq
{
  public bgdl(VisitorTroopCardFragment paramVisitorTroopCardFragment, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) == null) {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, new biso(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity()));
    }
    paramView = (aoep)this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramView != null))
    {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(0, 2131692036, 0);
      paramView.k(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      if (paramView != null) {
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131694305, 1500);
      } else {
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).b(2, 2131692035, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdl
 * JD-Core Version:    0.7.0.1
 */
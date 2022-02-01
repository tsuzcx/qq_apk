import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class beex
  implements DialogInterface.OnClickListener
{
  public beex(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131692125), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299080));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Beeu == null) {
      return;
    }
    paramDialogInterface = becr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.domainId, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.padId);
    if (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).getCheckBoxState()) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Beeu.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Long, paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.pad_url, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Beeu.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Long, paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.pad_url, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beex
 * JD-Core Version:    0.7.0.1
 */
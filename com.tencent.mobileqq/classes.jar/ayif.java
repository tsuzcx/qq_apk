import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class ayif
  implements DialogInterface.OnClickListener
{
  public ayif(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bbfj.g(BaseApplicationImpl.getContext())) {
      bcql.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131692321), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Ayia == null) {
      return;
    }
    paramDialogInterface = ayfx.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.domainId, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.padId);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Ayia.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.jdField_a_of_type_Long, paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqTeamworkPadInfo.pad_url, true);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayif
 * JD-Core Version:    0.7.0.1
 */
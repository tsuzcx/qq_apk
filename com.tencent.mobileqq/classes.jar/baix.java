import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

public class baix
  implements bhuk
{
  public baix(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, bagh parambagh, SparseArray paramSparseArray, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.jdField_a_of_type_Bagh.a;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      paramInt = -1;
    }
    switch (paramInt)
    {
    default: 
    case 2131720649: 
    case 2131720650: 
      for (;;)
      {
        TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.a.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bhuf.isShowing()) {
          this.jdField_a_of_type_Bhuf.dismiss();
        }
        return;
        paramInt = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).intValue();
        break;
        localUinRightInfo.uint32_right.set(1);
        continue;
        localUinRightInfo.uint32_right.set(2);
      }
    }
    if ((localUinRightInfo.uint32_right.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b == 1)) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131720646);; paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131720645))
    {
      bdgm.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getActivity(), 230, alud.a(2131715152), paramView, 2131690648, 2131691562, new baiy(this, localUinRightInfo), new baiz(this)).show();
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b != 1) {
        break;
      }
      azqs.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment), "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baix
 * JD-Core Version:    0.7.0.1
 */
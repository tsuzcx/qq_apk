import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

public class bedm
  implements bkzq
{
  public bedm(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, beaw parambeaw, SparseArray paramSparseArray, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.jdField_a_of_type_Beaw.a;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      paramInt = -1;
    }
    switch (paramInt)
    {
    default: 
    case 2131719223: 
    case 2131719224: 
      for (;;)
      {
        TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.a.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bkzi.isShowing()) {
          this.jdField_a_of_type_Bkzi.dismiss();
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
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131719220);; paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131719219))
    {
      bhdj.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getActivity(), 230, anvx.a(2131714140), paramView, 2131690697, 2131691448, new bedn(this, localUinRightInfo), new bedo(this)).show();
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b != 1) {
        break;
      }
      bdla.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment), "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedm
 * JD-Core Version:    0.7.0.1
 */
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

public class aygs
  implements bfph
{
  public aygs(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, ayeb paramayeb, SparseArray paramSparseArray, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.jdField_a_of_type_Ayeb.a;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      paramInt = -1;
    }
    switch (paramInt)
    {
    default: 
    case 2131720101: 
    case 2131720102: 
      for (;;)
      {
        TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.a.notifyDataSetChanged();
        if (this.jdField_a_of_type_Bfpc.isShowing()) {
          this.jdField_a_of_type_Bfpc.dismiss();
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
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131720098);; paramView = this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getString(2131720097))
    {
      bbdj.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.getActivity(), 230, ajya.a(2131714768), paramView, 2131690596, 2131691507, new aygt(this, localUinRightInfo), new aygu(this)).show();
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment.b != 1) {
        break;
      }
      axqy.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment), "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aygs
 * JD-Core Version:    0.7.0.1
 */
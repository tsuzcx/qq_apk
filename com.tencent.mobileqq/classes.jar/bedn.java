import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

class bedn
  implements DialogInterface.OnClickListener
{
  bedn(bedm parambedm, TimDocSSOMsg.UinRightInfo paramUinRightInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bedm.a.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bedm.a.jdField_a_of_type_Beav.b(String.valueOf(this.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get()));
    this.jdField_a_of_type_Bedm.a.jdField_a_of_type_Beav.notifyDataSetChanged();
    if (this.jdField_a_of_type_Bedm.a.b == 1) {
      bdla.b(TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_Bedm.a), "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedn
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;

final class atcd
  implements DialogInterface.OnClickListener
{
  atcd(asvg paramasvg, EditExtendFriendInfo.SchoolInfo paramSchoolInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Asvg != null) {
      this.jdField_a_of_type_Asvg.a(this.jdField_a_of_type_ComTencentPbProfilecardEditExtendFriendInfo$SchoolInfo);
    }
    bdll.b(null, "dc00898", "", "", "0X800ADA8", "0X800ADA8", 1, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcd
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class ayod
  implements DialogInterface.OnClickListener
{
  ayod(ayob paramayob, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bhpc.dismiss();
    this.jdField_a_of_type_Ayob.a.a.c();
    paramInt = ((Integer)axws.a(this.jdField_a_of_type_Ayob.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    bdll.b(this.jdField_a_of_type_Ayob.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, axxb.a(this.jdField_a_of_type_Ayob.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayod
 * JD-Core Version:    0.7.0.1
 */
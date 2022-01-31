import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avox
  implements DialogInterface.OnClickListener
{
  avox(avov paramavov, bdjz parambdjz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bdjz.dismiss();
    this.jdField_a_of_type_Avov.a.a.c();
    paramInt = ((Integer)auwq.a(this.jdField_a_of_type_Avov.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    azqs.b(this.jdField_a_of_type_Avov.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, auwz.a(this.jdField_a_of_type_Avov.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avox
 * JD-Core Version:    0.7.0.1
 */
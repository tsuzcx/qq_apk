import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atsq
  implements DialogInterface.OnClickListener
{
  atsq(atso paramatso, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbgu.dismiss();
    this.jdField_a_of_type_Atso.a.a.c();
    paramInt = ((Integer)atbi.a(this.jdField_a_of_type_Atso.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    axqy.b(this.jdField_a_of_type_Atso.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, atbr.a(this.jdField_a_of_type_Atso.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsq
 * JD-Core Version:    0.7.0.1
 */
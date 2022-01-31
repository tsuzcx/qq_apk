import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atto
  implements DialogInterface.OnClickListener
{
  atto(attm paramattm, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbgu.dismiss();
    this.jdField_a_of_type_Attm.a.a.c();
    paramInt = ((Integer)atbi.a(this.jdField_a_of_type_Attm.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    axqy.b(this.jdField_a_of_type_Attm.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, atbr.a(this.jdField_a_of_type_Attm.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atto
 * JD-Core Version:    0.7.0.1
 */
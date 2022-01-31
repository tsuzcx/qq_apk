import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avko
  implements DialogInterface.OnClickListener
{
  avko(avkm paramavkm, bdfq parambdfq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bdfq.dismiss();
    this.jdField_a_of_type_Avkm.a.a.c();
    paramInt = ((Integer)aush.a(this.jdField_a_of_type_Avkm.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    azmj.b(this.jdField_a_of_type_Avkm.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, ausq.a(this.jdField_a_of_type_Avkm.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avko
 * JD-Core Version:    0.7.0.1
 */
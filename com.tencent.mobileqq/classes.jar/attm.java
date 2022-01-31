import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class attm
  implements DialogInterface.OnClickListener
{
  attm(attk paramattk, bbgg parambbgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbgg.dismiss();
    this.jdField_a_of_type_Attk.a.a.c();
    paramInt = ((Integer)atbg.a(this.jdField_a_of_type_Attk.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    axqw.b(this.jdField_a_of_type_Attk.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, atbp.a(this.jdField_a_of_type_Attk.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attm
 * JD-Core Version:    0.7.0.1
 */
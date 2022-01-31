import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class asxi
  implements DialogInterface.OnClickListener
{
  asxi(asxg paramasxg, bafb parambafb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bafb.dismiss();
    this.jdField_a_of_type_Asxg.a.a.c();
    paramInt = ((Integer)asfc.a(this.jdField_a_of_type_Asxg.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    awqx.b(this.jdField_a_of_type_Asxg.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, asfl.a(this.jdField_a_of_type_Asxg.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asxi
 * JD-Core Version:    0.7.0.1
 */
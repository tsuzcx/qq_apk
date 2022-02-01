import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class axwh
  implements DialogInterface.OnClickListener
{
  axwh(axwf paramaxwf, bgpa parambgpa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bgpa.dismiss();
    this.jdField_a_of_type_Axwf.a.a.c();
    paramInt = ((Integer)axdz.a(this.jdField_a_of_type_Axwf.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    bcst.b(this.jdField_a_of_type_Axwf.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, axei.a(this.jdField_a_of_type_Axwf.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwh
 * JD-Core Version:    0.7.0.1
 */
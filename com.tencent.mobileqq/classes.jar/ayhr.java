import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ayhr
  implements DialogInterface.OnClickListener
{
  ayhr(ayhp paramayhp, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_Ayhp.a.a.d();
    paramInt = ((Integer)axqc.a(this.jdField_a_of_type_Ayhp.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    bdla.b(this.jdField_a_of_type_Ayhp.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, axql.a(this.jdField_a_of_type_Ayhp.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhr
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class axbl
  implements DialogInterface.OnClickListener
{
  axbl(axbj paramaxbj, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_Axbj.a.a.d();
    paramInt = ((Integer)awka.a(this.jdField_a_of_type_Axbj.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    bcef.b(this.jdField_a_of_type_Axbj.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, awkj.a(this.jdField_a_of_type_Axbj.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbl
 * JD-Core Version:    0.7.0.1
 */
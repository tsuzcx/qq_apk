import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

class baul
  implements DialogInterface.OnDismissListener
{
  baul(baui parambaui) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.jdField_b_of_type_Boolean = false;
    if ((!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) || (((this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4)) && ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 0)))) {
      return;
    }
    ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baul
 * JD-Core Version:    0.7.0.1
 */
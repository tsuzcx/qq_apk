import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;

class batw
  implements DialogInterface.OnDismissListener
{
  batw(batu parambatu) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.jdField_a_of_type_Int == -1) && ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)))
    {
      ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "mShareActionSheet noItemClick, onDismiss");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batw
 * JD-Core Version:    0.7.0.1
 */
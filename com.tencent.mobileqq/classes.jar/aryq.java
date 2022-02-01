import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aryq
  implements DialogInterface.OnClickListener
{
  aryq(aryn paramaryn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    QLog.d(aryn.a(), 1, "showConfirmDialog, cancel click");
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, aryn.d, aryn.d, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryq
 * JD-Core Version:    0.7.0.1
 */
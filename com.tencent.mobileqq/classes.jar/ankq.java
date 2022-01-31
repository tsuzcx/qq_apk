import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ankq
  implements DialogInterface.OnClickListener
{
  ankq(ankn paramankn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    QLog.d(ankn.a(), 1, "showConfirmDialog, cancel click");
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, ankn.d, ankn.d, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ankq
 * JD-Core Version:    0.7.0.1
 */
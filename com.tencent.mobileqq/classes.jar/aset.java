import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class aset
  implements DialogInterface.OnCancelListener
{
  aset(ases paramases, BaseChatPie paramBaseChatPie) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "dialog cancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aset
 * JD-Core Version:    0.7.0.1
 */
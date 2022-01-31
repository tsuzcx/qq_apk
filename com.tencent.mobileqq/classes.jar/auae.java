import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class auae
  implements DialogInterface.OnCancelListener
{
  auae(auad paramauad, BaseChatPie paramBaseChatPie) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "dialog cancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auae
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class awtr
  implements DialogInterface.OnCancelListener
{
  awtr(awtq paramawtq, BaseChatPie paramBaseChatPie) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "dialog cancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.finish(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtr
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

final class avcm
  implements DialogInterface.OnClickListener
{
  avcm(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog back");
    }
    avcj.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcm
 * JD-Core Version:    0.7.0.1
 */
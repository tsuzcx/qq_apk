import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class arzr
  implements DialogInterface.OnClickListener
{
  arzr(Intent paramIntent, int paramInt, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("sdk_mult_share_source_app_id", 0L);
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sdk_mult_share_msg_service_id", 0);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardDialogMgr", 2, "-->showMultShareDialog--back");
        }
        if (this.jdField_a_of_type_Int == 2) {
          asdt.a(this.jdField_a_of_type_AndroidAppActivity, "shareToQQ", l, 0, asdt.a);
        }
        while (this.jdField_a_of_type_Int == 1)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A740", new String[0]);
          return;
          asdt.a(l, i, this.jdField_a_of_type_AndroidAppActivity, null);
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A73C", new String[0]);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 901503));
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A73E", new String[0]);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardDialogMgr", 2, "-->showMultShareDialog--stay");
      }
      if (this.jdField_a_of_type_Int == 901503) {
        asdt.a(this.jdField_a_of_type_AndroidAppActivity, "shareToQQ", l, 0, asdt.a);
      }
      while (this.jdField_a_of_type_Int == 1)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A73F", new String[0]);
        return;
        if (this.jdField_a_of_type_Int == 3) {
          asdt.a(l, i, this.jdField_a_of_type_AndroidAppActivity, null);
        } else {
          asdt.a(l, i, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A73B", new String[0]);
        return;
      }
    } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 901503));
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A73D", new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzr
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class bhkz
  extends BroadcastReceiver
{
  public bhkz(BusinessCommonConfig paramBusinessCommonConfig, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!"tencent.businessnotify.subprocess.to.qq".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("event", 0);
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqUtilsBusinessCommonConfig.TAG, 1, "收到其他进程的通知, event[" + i + "]");
    } while (i != 1);
    BusinessCommonConfig.onDownloadRequest(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkz
 * JD-Core Version:    0.7.0.1
 */
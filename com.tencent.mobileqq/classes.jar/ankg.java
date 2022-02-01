import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ankg
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AccountPhoneUnityManager", 1, "onReceive broadcast");
    bcef.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X800B3EB", "0X800B3EB", 0, 0, "", "", "", "");
    paramIntent = anjy.a().a(anjz.class);
    if ((paramIntent instanceof anjz))
    {
      ((anjz)paramIntent).d();
      anjz.a((anjz)paramIntent, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankg
 * JD-Core Version:    0.7.0.1
 */
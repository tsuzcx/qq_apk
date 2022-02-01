import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aomz
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AccountPhoneUnityManager", 1, "onReceive broadcast");
    bdla.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X800B3EB", "0X800B3EB", 0, 0, "", "", "", "");
    paramIntent = aomr.a().a(aoms.class);
    if ((paramIntent instanceof aoms))
    {
      ((aoms)paramIntent).d();
      aoms.a((aoms)paramIntent, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomz
 * JD-Core Version:    0.7.0.1
 */
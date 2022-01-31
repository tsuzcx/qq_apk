import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime.Status;
import mqq.util.WeakReference;

final class atld
  extends BroadcastReceiver
{
  private int jdField_a_of_type_Int = -1;
  private final WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  
  private atld(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localQQAppInterface != null) && (localQQAppInterface.getOnlineStatus() == AppRuntime.Status.online) && (localQQAppInterface.getExtOnlineStatus() == 1000L))
    {
      localQQAppInterface.a(AppRuntime.Status.online, 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 0, "toggleChangeInCharging");
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!TextUtils.equals(paramContext, "android.intent.action.ACTION_POWER_CONNECTED")) {
        break label23;
      }
      a();
    }
    label23:
    int i;
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        do
        {
          do
          {
            return;
            if (TextUtils.equals(paramContext, "android.intent.action.ACTION_POWER_DISCONNECTED"))
            {
              a();
              return;
            }
          } while (!TextUtils.equals(paramContext, "android.intent.action.BATTERY_CHANGED"));
          paramContext = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
        } while (paramContext == null);
        localStatus = paramContext.getOnlineStatus();
        l = paramContext.getExtOnlineStatus();
        if (QLog.isColorLevel()) {
          QLog.d("OnLineStatusHelper", 0, "onBatteryChanged onlineStatus == " + localStatus + ", extOnlineStatus() == " + l);
        }
      } while ((localStatus != AppRuntime.Status.online) || (l != 1000L));
      i = paramIntent.getIntExtra("level", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 0, "onBatteryChanged curLevel == " + i + ", lastLevel == " + this.jdField_a_of_type_Int);
      }
    } while (this.jdField_a_of_type_Int == i);
    this.jdField_a_of_type_Int = i;
    paramContext.notifyObservers(atla.class, 0, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atld
 * JD-Core Version:    0.7.0.1
 */
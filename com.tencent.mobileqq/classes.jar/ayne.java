import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class ayne
  extends aypr
{
  ayne(aymu paramaymu) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if ((!aymu.a(this.a)) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(aymu.a(this.a)) });
      }
    }
    boolean bool;
    do
    {
      return;
      bool = paramBundle.getBoolean("param_need_switch_online_status", false);
      if ((!paramBoolean) || (paramBundle == null)) {
        break;
      }
      i = paramBundle.getInt("StatusId", 0);
      aymu.a(this.a, AppRuntime.Status.online, i, false);
    } while (bool);
    QQToast.a(aymu.a(this.a).getApp(), 2, 2131691178, 1).a();
    this.a.c();
    return;
    if (bool) {}
    for (int i = 2131697641;; i = 2131691179)
    {
      QQToast.a(aymu.a(this.a), 1, i, 1).a();
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayne
 * JD-Core Version:    0.7.0.1
 */
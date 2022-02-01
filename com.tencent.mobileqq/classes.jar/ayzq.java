import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class ayzq
  extends azce
{
  ayzq(ayzg paramayzg) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if ((!ayzg.a(this.a)) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(ayzg.a(this.a)) });
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
      ayzg.a(this.a, AppRuntime.Status.online, i, false);
    } while (bool);
    QQToast.a(ayzg.a(this.a).getApp(), 2, 2131691302, 1).a();
    this.a.c();
    return;
    if (bool) {}
    for (int i = 2131698154;; i = 2131691303)
    {
      QQToast.a(ayzg.a(this.a), 1, i, 1).a();
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzq
 * JD-Core Version:    0.7.0.1
 */
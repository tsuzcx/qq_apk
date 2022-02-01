import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

class axtf
  extends axvs
{
  axtf(axsv paramaxsv) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if ((!axsv.a(this.a)) || (paramBundle == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "receiveModOnlineStatusPermission: no needShowOnlineStatusToast needShowOnlineStatusToast=", Boolean.valueOf(axsv.a(this.a)) });
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
      axsv.a(this.a, AppRuntime.Status.online, i, false);
    } while (bool);
    QQToast.a(axsv.a(this.a).getApp(), 2, 2131691217, 1).a();
    this.a.c();
    return;
    if (bool) {}
    for (int i = 2131697871;; i = 2131691218)
    {
      QQToast.a(axsv.a(this.a), 1, i, 1).a();
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtf
 * JD-Core Version:    0.7.0.1
 */
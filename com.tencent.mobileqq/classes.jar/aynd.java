import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel.18.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class aynd
  extends aypl
{
  aynd(aymu paramaymu) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null) {
      i = (int)paramBundle.getLong("onlineStatus", 0L);
    }
    paramBundle = AppRuntime.Status.build(i);
    if ((paramBoolean) && (aymu.a(this.a) != null)) {
      aymu.a(this.a).a(paramBundle);
    }
    ThreadManager.getUIHandler().post(new AccountPanel.18.1(this, paramBoolean, paramBundle));
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    if (!aymu.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "onSetExtInfo: no needShowOnlineStatusToast ");
      }
    }
    boolean bool2;
    do
    {
      boolean bool1;
      do
      {
        return;
        bool1 = paramBundle.getBoolean("from_register", false);
        bool2 = paramBundle.getBoolean("from_modify", false);
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, new Object[] { "onSetExtInfo: invoked. ", " isFromRegister: ", Boolean.valueOf(bool1), " isFromModify=", Boolean.valueOf(bool2) });
        }
        if (!paramBoolean) {
          break;
        }
        i = paramBundle.getInt("StatusId");
        aymu.a(this.a, AppRuntime.Status.online, i, false);
        if (bool2)
        {
          QQToast.a(aymu.a(this.a).getApp(), 2, 2131691178, 1).a();
          this.a.c();
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountPanel", 2, new Object[] { "onSetExtInfo: invoked. ", " statusId: ", Integer.valueOf(i) });
      return;
      if (!bool1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, "onSetExtInfo: invoked. isFromRegister ");
    return;
    if (bool2) {}
    for (int i = 2131691179;; i = 2131697641)
    {
      QQToast.a(aymu.a(this.a).getApp(), 1, i, 1).a();
      this.a.c();
      return;
    }
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    super.c(paramBoolean, paramBundle);
    if (paramBoolean) {
      aymu.a(this.a, aymu.a(this.a), aymu.b(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynd
 * JD-Core Version:    0.7.0.1
 */
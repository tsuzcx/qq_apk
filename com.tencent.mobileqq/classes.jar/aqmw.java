import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aqmw
  extends AbstractThreadedSyncAdapter
{
  private Context a;
  
  public aqmw(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.a = paramContext;
  }
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync");
    }
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramAccount = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
          if ((paramAccount == null) || (!paramAccount.isLogin()))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | app is null or not login, " + paramAccount);
          }
        }
        catch (Throwable paramAccount)
        {
          for (;;)
          {
            QLog.e("ContactSync.SyncAdapter", 1, "onPerformSync exception", paramAccount);
            paramAccount = null;
          }
          try
          {
            ((ContactSyncManager)paramAccount.getManager(41)).a(1);
            return;
          }
          catch (Throwable paramAccount) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | syncAllContacts exception", paramAccount);
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled()");
    }
    super.onSyncCanceled();
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled(Thread paramThread)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled(thread)");
    }
    super.onSyncCanceled(paramThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmw
 * JD-Core Version:    0.7.0.1
 */
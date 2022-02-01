import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;

public class arsq
  implements AccountManagerCallback<Boolean>
{
  public arsq(ContactSyncManager paramContactSyncManager) {}
  
  public void run(AccountManagerFuture<Boolean> paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsq
 * JD-Core Version:    0.7.0.1
 */
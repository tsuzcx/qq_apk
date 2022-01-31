import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.qphone.base.util.QLog;

class amod
  implements AccountManagerCallback<Boolean>
{
  amod(amoa paramamoa) {}
  
  public void run(AccountManagerFuture<Boolean> paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amod
 * JD-Core Version:    0.7.0.1
 */
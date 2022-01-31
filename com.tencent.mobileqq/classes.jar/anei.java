import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager.1.1;
import com.tencent.qphone.base.util.QLog;

public class anei
  extends aume
{
  anei(aneh paramaneh) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    askl localaskl = (askl)this.a.a.getManager(11);
    int i = localaskl.d();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + aneh.b(str2) + " | currentUin = " + aneh.b(str1));
    }
    if (localaskl.c()) {
      if (TextUtils.isEmpty(str2)) {
        aneh.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        aneh.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        aneh.a(this.a).removeCallbacksAndMessages(null);
        aneh.a(this.a).sendEmptyMessage(2);
        aneh.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localaskl.a() == null) || (localaskl.a().lastUsedFlag != 3L)) && ((i != 7) || (localaskl.a() == null) || (!localaskl.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    aneh.a(this.a).removeCallbacksAndMessages(null);
    aneh.a(this.a).sendEmptyMessage(2);
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anei
 * JD-Core Version:    0.7.0.1
 */
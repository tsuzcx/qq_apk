import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import mqq.os.MqqHandler;

class arpn
  implements Handler.Callback
{
  arpn(arpm paramarpm) {}
  
  private void a()
  {
    if (arpm.a(this.a) != null) {
      arpm.a(this.a).setRefreshing(false);
    }
    if (arpm.a(this.a) != null) {
      arpm.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      bcpw.a(this.a.a(), 1, 2131719788, 0).b(arpm.a(this.a));
      a();
      return false;
    case 4: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label134;
        }
        arpm.a(this.a);
        if (arpm.a(this.a) == null) {
          break;
        }
        arpm.a(this.a).a(0);
        this.a.a.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      a();
      bcpw.a(this.a.a(), 1, 2131719788, 0).b(arpm.a(this.a));
      return false;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpn
 * JD-Core Version:    0.7.0.1
 */
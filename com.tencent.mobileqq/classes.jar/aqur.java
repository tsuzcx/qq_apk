import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import mqq.os.MqqHandler;

class aqur
  implements Handler.Callback
{
  aqur(aquq paramaquq) {}
  
  private void a()
  {
    if (aquq.a(this.a) != null) {
      aquq.a(this.a).setRefreshing(false);
    }
    if (aquq.a(this.a) != null) {
      aquq.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      bbmy.a(this.a.a(), 1, 2131653904, 0).b(aquq.a(this.a));
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
        aquq.a(this.a);
        if (aquq.a(this.a) == null) {
          break;
        }
        aquq.a(this.a).a(0);
        this.a.a.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      a();
      bbmy.a(this.a.a(), 1, 2131653904, 0).b(aquq.a(this.a));
      return false;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqur
 * JD-Core Version:    0.7.0.1
 */
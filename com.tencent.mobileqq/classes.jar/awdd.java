import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class awdd
  implements Handler.Callback
{
  awdd(awdc paramawdc) {}
  
  private void a()
  {
    if (awdc.a(this.a) != null) {
      awdc.a(this.a).setRefreshing(false);
    }
    if (awdc.a(this.a) != null) {
      awdc.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      QQToast.a(this.a.a(), 1, 2131718993, 0).b(awdc.a(this.a));
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
        awdc.a(this.a);
        if (awdc.a(this.a) == null) {
          break;
        }
        awdc.a(this.a).a(0);
        this.a.a.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      a();
      QQToast.a(this.a.a(), 1, 2131718993, 0).b(awdc.a(this.a));
      return false;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdd
 * JD-Core Version:    0.7.0.1
 */
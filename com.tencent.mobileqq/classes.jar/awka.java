import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class awka
  implements Handler.Callback
{
  awka(awjz paramawjz) {}
  
  private void a()
  {
    if (awjz.a(this.a) != null) {
      awjz.a(this.a).setRefreshing(false);
    }
    if (awjz.a(this.a) != null) {
      awjz.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      QQToast.a(this.a.a(), 1, 2131718362, 0).b(awjz.a(this.a));
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
        awjz.a(this.a);
        if (awjz.a(this.a) == null) {
          break;
        }
        awjz.a(this.a).a(0);
        this.a.a.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      a();
      QQToast.a(this.a.a(), 1, 2131718362, 0).b(awjz.a(this.a));
      return false;
    }
    a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awka
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bkew
  extends Handler
{
  public bkew(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bkev.a(0);
    }
    while ((paramMessage.what != 1) || (!bkev.a()) || (TextUtils.isEmpty(bkev.a())) || (TextUtils.isEmpty(bkev.b()))) {
      return;
    }
    String str1 = bkev.a();
    String str2 = bkev.b();
    int i = bkev.a();
    int j = bkev.b();
    String str3 = bkev.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bkev.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bkev.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkew
 * JD-Core Version:    0.7.0.1
 */
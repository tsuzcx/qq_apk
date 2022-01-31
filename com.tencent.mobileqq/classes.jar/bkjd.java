import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bkjd
  extends Handler
{
  public bkjd(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bkjc.a(0);
    }
    while ((paramMessage.what != 1) || (!bkjc.a()) || (TextUtils.isEmpty(bkjc.a())) || (TextUtils.isEmpty(bkjc.b()))) {
      return;
    }
    String str1 = bkjc.a();
    String str2 = bkjc.b();
    int i = bkjc.a();
    int j = bkjc.b();
    String str3 = bkjc.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bkjc.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bkjc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjd
 * JD-Core Version:    0.7.0.1
 */
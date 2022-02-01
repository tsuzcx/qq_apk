import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bleh
  extends Handler
{
  public bleh(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bleg.a(0);
    }
    while ((paramMessage.what != 1) || (!bleg.a()) || (TextUtils.isEmpty(bleg.a())) || (TextUtils.isEmpty(bleg.b()))) {
      return;
    }
    String str1 = bleg.a();
    String str2 = bleg.b();
    int i = bleg.a();
    int j = bleg.b();
    String str3 = bleg.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bleg.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bleg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleh
 * JD-Core Version:    0.7.0.1
 */
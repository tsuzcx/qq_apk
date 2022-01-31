import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bgth
  extends Handler
{
  public bgth(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bgtg.a(0);
    }
    while ((paramMessage.what != 1) || (!bgtg.a()) || (TextUtils.isEmpty(bgtg.a())) || (TextUtils.isEmpty(bgtg.b()))) {
      return;
    }
    String str1 = bgtg.a();
    String str2 = bgtg.b();
    int i = bgtg.a();
    int j = bgtg.b();
    String str3 = bgtg.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bgtg.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bgtg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgth
 * JD-Core Version:    0.7.0.1
 */
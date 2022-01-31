import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bida
  extends Handler
{
  public bida(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bicz.a(0);
    }
    while ((paramMessage.what != 1) || (!bicz.a()) || (TextUtils.isEmpty(bicz.a())) || (TextUtils.isEmpty(bicz.b()))) {
      return;
    }
    String str1 = bicz.a();
    String str2 = bicz.b();
    int i = bicz.a();
    int j = bicz.b();
    String str3 = bicz.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bicz.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bicz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bida
 * JD-Core Version:    0.7.0.1
 */
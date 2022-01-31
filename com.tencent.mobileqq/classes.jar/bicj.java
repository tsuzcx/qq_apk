import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bicj
  extends Handler
{
  public bicj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bici.a(0);
    }
    while ((paramMessage.what != 1) || (!bici.a()) || (TextUtils.isEmpty(bici.a())) || (TextUtils.isEmpty(bici.b()))) {
      return;
    }
    String str1 = bici.a();
    String str2 = bici.b();
    int i = bici.a();
    int j = bici.b();
    String str3 = bici.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bici.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bici.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicj
 * JD-Core Version:    0.7.0.1
 */
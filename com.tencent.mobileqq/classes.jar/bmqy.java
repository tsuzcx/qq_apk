import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bmqy
  extends Handler
{
  public bmqy(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bmqx.a(0);
    }
    while ((paramMessage.what != 1) || (!bmqx.a()) || (TextUtils.isEmpty(bmqx.a())) || (TextUtils.isEmpty(bmqx.b()))) {
      return;
    }
    String str1 = bmqx.a();
    String str2 = bmqx.b();
    int i = bmqx.a();
    int j = bmqx.b();
    String str3 = bmqx.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bmqx.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bmqx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqy
 * JD-Core Version:    0.7.0.1
 */
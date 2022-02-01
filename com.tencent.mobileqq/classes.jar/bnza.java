import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bnza
  extends Handler
{
  public bnza(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bnyz.a(0);
    }
    while ((paramMessage.what != 1) || (!bnyz.a()) || (TextUtils.isEmpty(bnyz.a())) || (TextUtils.isEmpty(bnyz.b()))) {
      return;
    }
    String str1 = bnyz.a();
    String str2 = bnyz.b();
    int i = bnyz.a();
    int j = bnyz.b();
    String str3 = bnyz.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bnyz.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bnyz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnza
 * JD-Core Version:    0.7.0.1
 */
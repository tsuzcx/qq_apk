import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class bmxs
  extends Handler
{
  public bmxs(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bmxr.a(0);
    }
    while ((paramMessage.what != 1) || (!bmxr.a()) || (TextUtils.isEmpty(bmxr.a())) || (TextUtils.isEmpty(bmxr.b()))) {
      return;
    }
    String str1 = bmxr.a();
    String str2 = bmxr.b();
    int i = bmxr.a();
    int j = bmxr.b();
    String str3 = bmxr.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    bmxr.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    bmxr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxs
 * JD-Core Version:    0.7.0.1
 */
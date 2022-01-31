import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.weiyun.ResponseHandler;

public class amqr
  extends Handler
{
  public amqr(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      ResponseHandler.a(0);
    }
    while ((paramMessage.what != 1) || (!ResponseHandler.a()) || (TextUtils.isEmpty(ResponseHandler.a())) || (TextUtils.isEmpty(ResponseHandler.b()))) {
      return;
    }
    String str1 = ResponseHandler.a();
    String str2 = ResponseHandler.b();
    int i = ResponseHandler.a();
    int j = ResponseHandler.b();
    String str3 = ResponseHandler.a(BaseApplicationImpl.getApplication());
    Process.setThreadPriority(10);
    ResponseHandler.a((QQAppInterface)paramMessage.obj, str1, str2, i, j, str3);
    ResponseHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqr
 * JD-Core Version:    0.7.0.1
 */
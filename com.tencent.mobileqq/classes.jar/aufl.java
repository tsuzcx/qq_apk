import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aufl
  extends Handler
{
  public aufl() {}
  
  public aufl(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ChatBackgroundManager.c < 3)
      {
        paramMessage = (String)localObject[0];
        localObject = (QQAppInterface)localObject[1];
        ChatBackgroundManager.a((QQAppInterface)localObject, paramMessage, azri.a(BaseApplication.getContext()));
        ChatBackgroundManager.c += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "reportTimes is:" + ChatBackgroundManager.c);
        }
        Message localMessage = ChatBackgroundManager.a.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = new Object[] { paramMessage, localObject };
        ChatBackgroundManager.a.sendMessageDelayed(localMessage, 120000L);
      }
    }
    else {
      return;
    }
    ChatBackgroundManager.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufl
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class avok
  extends Handler
{
  avok(avoj paramavoj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)avoj.a(this.a).get();
    if (localQQAppInterface == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = "https://openmobile.qq.com/gameteam/get_team_context?uin=" + localQQAppInterface.getCurrentAccountUin();
    this.a.a(paramMessage, null);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avok
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class askx
  extends Handler
{
  askx(askw paramaskw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)askw.a(this.a).get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askx
 * JD-Core Version:    0.7.0.1
 */
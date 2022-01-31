import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.qphone.base.util.QLog;

public class arrd
  implements Handler.Callback
{
  public arrd(ListenTogetherManager paramListenTogetherManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    paramMessage = this.a.a();
    if (paramMessage != null)
    {
      paramMessage.a = (SystemClock.elapsedRealtime() - paramMessage.c + paramMessage.a);
      paramMessage.c = SystemClock.elapsedRealtime();
      boolean bool = ListenTogetherManager.a(this.a).a(paramMessage);
      QLog.i("ListenTogether.Seek", 1, "MSG_TYPE_TIME_SYNC seek is: " + paramMessage.a + " currentTime: " + System.currentTimeMillis() + " result: " + bool);
    }
    for (;;)
    {
      ListenTogetherManager.a(this.a).removeMessages(1001);
      ListenTogetherManager.a(this.a).sendEmptyMessageDelayed(1001, arqq.a().a);
      return true;
      QLog.i("ListenTogether.Manager", 1, "MSG_TYPE_TIME_SYNC startPlay musicInfo is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */
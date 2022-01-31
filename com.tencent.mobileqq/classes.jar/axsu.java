import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richmedia.conn.LiteTcpConnection;

public class axsu
  extends Handler
{
  public axsu(LiteTcpConnection paramLiteTcpConnection, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    if (LiteTcpConnection.a(this.a) != null) {
      LiteTcpConnection.a(this.a).sendEmptyMessage(3);
    }
  }
  
  public void b()
  {
    axsu localaxsu = LiteTcpConnection.a(this.a);
    if (localaxsu != null) {
      localaxsu.sendEmptyMessage(2);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      LiteTcpConnection.a(this.a, LiteTcpConnection.a(this.a));
    }
    do
    {
      return;
      if (paramMessage.what == 2)
      {
        LiteTcpConnection.a(this.a);
        return;
      }
    } while (paramMessage.what != 3);
    LiteTcpConnection.a(this.a).quit();
    LiteTcpConnection.a(this.a, null);
    LiteTcpConnection.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsu
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.utils.MiniLog.WriteHandler.1;
import java.util.concurrent.LinkedBlockingQueue;

public class bfgl
  extends Handler
{
  private bfgl(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (bfgi.a().isEmpty());
    beiw.a(new MiniLog.WriteHandler.1(this), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgl
 * JD-Core Version:    0.7.0.1
 */
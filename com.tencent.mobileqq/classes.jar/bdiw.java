import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class bdiw
  extends Handler
{
  private bdiw(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bdit parambdit)
  {
    if (parambdit == null) {}
    for (;;)
    {
      return;
      if (!bdit.a(parambdit))
      {
        bdit.a(parambdit, System.currentTimeMillis() + bdit.a(parambdit));
        bdit.b(parambdit, true);
      }
      parambdit.a();
      if (bdit.a(parambdit) == 0) {}
      for (int i = 200; bdit.b(parambdit) + i < bdit.c(parambdit); i = 400)
      {
        bdit.a().add(new WeakReference(parambdit));
        long l = bdit.b(parambdit);
        a(parambdit, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(bdit parambdit, long paramLong)
  {
    bdnw.a("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    bdit.a().add(new WeakReference(parambdit));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void b(bdit parambdit)
  {
    if (parambdit == null) {}
    do
    {
      return;
      bdit.b(parambdit, false);
    } while (bdit.a(parambdit) == null);
    bdit.a(parambdit).cancel();
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (bdnw.a()) {
          bdnw.a("QQToast", "MSG_SHOW_TOAST received");
        }
        paramMessage = (WeakReference)bdit.a().poll();
      } while (paramMessage == null);
      a((bdit)paramMessage.get());
      return;
      if (bdnw.a()) {
        bdnw.a("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)bdit.a().poll();
    } while (paramMessage == null);
    b((bdit)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdiw
 * JD-Core Version:    0.7.0.1
 */
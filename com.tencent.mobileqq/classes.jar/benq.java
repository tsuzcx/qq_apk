import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class benq
  extends Handler
{
  private benq(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(benn parambenn)
  {
    if (parambenn == null) {}
    for (;;)
    {
      return;
      if (!benn.a(parambenn))
      {
        benn.a(parambenn, System.currentTimeMillis() + benn.a(parambenn));
        benn.b(parambenn, true);
      }
      parambenn.a();
      if (benn.a(parambenn) == 0) {}
      for (int i = 200; benn.b(parambenn) + i < benn.c(parambenn); i = 400)
      {
        benn.a().add(new WeakReference(parambenn));
        long l = benn.b(parambenn);
        a(parambenn, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(benn parambenn, long paramLong)
  {
    betc.a("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    benn.a().add(new WeakReference(parambenn));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void b(benn parambenn)
  {
    if (parambenn == null) {}
    do
    {
      return;
      benn.b(parambenn, false);
    } while (benn.a(parambenn) == null);
    benn.a(parambenn).cancel();
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
        if (betc.a()) {
          betc.a("QQToast", "MSG_SHOW_TOAST received");
        }
        paramMessage = (WeakReference)benn.a().poll();
      } while (paramMessage == null);
      a((benn)paramMessage.get());
      return;
      if (betc.a()) {
        betc.a("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)benn.a().poll();
    } while (paramMessage == null);
    b((benn)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benq
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class bemz
  extends Handler
{
  private bemz(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bemw parambemw)
  {
    if (parambemw == null) {}
    for (;;)
    {
      return;
      if (!bemw.a(parambemw))
      {
        bemw.a(parambemw, System.currentTimeMillis() + bemw.a(parambemw));
        bemw.b(parambemw, true);
      }
      parambemw.a();
      if (bemw.a(parambemw) == 0) {}
      for (int i = 200; bemw.b(parambemw) + i < bemw.c(parambemw); i = 400)
      {
        bemw.a().add(new WeakReference(parambemw));
        long l = bemw.b(parambemw);
        a(parambemw, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(bemw parambemw, long paramLong)
  {
    besl.a("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    bemw.a().add(new WeakReference(parambemw));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void b(bemw parambemw)
  {
    if (parambemw == null) {}
    do
    {
      return;
      bemw.b(parambemw, false);
    } while (bemw.a(parambemw) == null);
    bemw.a(parambemw).cancel();
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
        if (besl.a()) {
          besl.a("QQToast", "MSG_SHOW_TOAST received");
        }
        paramMessage = (WeakReference)bemw.a().poll();
      } while (paramMessage == null);
      a((bemw)paramMessage.get());
      return;
      if (besl.a()) {
        besl.a("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)bemw.a().poll();
    } while (paramMessage == null);
    b((bemw)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemz
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class bgni
  extends Handler
{
  private bgni(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bgnf parambgnf)
  {
    if (parambgnf == null) {}
    for (;;)
    {
      return;
      if (!bgnf.a(parambgnf))
      {
        bgnf.a(parambgnf, System.currentTimeMillis() + bgnf.a(parambgnf));
        bgnf.b(parambgnf, true);
      }
      parambgnf.a();
      if (bgnf.a(parambgnf) == 0) {}
      for (int i = 200; bgnf.b(parambgnf) + i < bgnf.c(parambgnf); i = 400)
      {
        bgnf.a().add(new WeakReference(parambgnf));
        long l = bgnf.b(parambgnf);
        a(parambgnf, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(bgnf parambgnf, long paramLong)
  {
    QMLog.d("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    bgnf.a().add(new WeakReference(parambgnf));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void b(bgnf parambgnf)
  {
    if (parambgnf == null) {}
    do
    {
      return;
      bgnf.b(parambgnf, false);
    } while (bgnf.a(parambgnf) == null);
    bgnf.a(parambgnf).cancel();
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
        if (QMLog.isColorLevel()) {
          QMLog.d("QQToast", "MSG_SHOW_TOAST received");
        }
        paramMessage = (WeakReference)bgnf.a().poll();
      } while (paramMessage == null);
      a((bgnf)paramMessage.get());
      return;
      if (QMLog.isColorLevel()) {
        QMLog.d("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)bgnf.a().poll();
    } while (paramMessage == null);
    b((bgnf)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgni
 * JD-Core Version:    0.7.0.1
 */
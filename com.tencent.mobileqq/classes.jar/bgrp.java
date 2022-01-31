import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class bgrp
  extends Handler
{
  private bgrp(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bgrm parambgrm)
  {
    if (parambgrm == null) {}
    for (;;)
    {
      return;
      if (!bgrm.a(parambgrm))
      {
        bgrm.a(parambgrm, System.currentTimeMillis() + bgrm.a(parambgrm));
        bgrm.b(parambgrm, true);
      }
      parambgrm.a();
      if (bgrm.a(parambgrm) == 0) {}
      for (int i = 200; bgrm.b(parambgrm) + i < bgrm.c(parambgrm); i = 400)
      {
        bgrm.a().add(new WeakReference(parambgrm));
        long l = bgrm.b(parambgrm);
        a(parambgrm, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(bgrm parambgrm, long paramLong)
  {
    QMLog.d("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    bgrm.a().add(new WeakReference(parambgrm));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void b(bgrm parambgrm)
  {
    if (parambgrm == null) {}
    do
    {
      return;
      bgrm.b(parambgrm, false);
    } while (bgrm.a(parambgrm) == null);
    bgrm.a(parambgrm).cancel();
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
        paramMessage = (WeakReference)bgrm.a().poll();
      } while (paramMessage == null);
      a((bgrm)paramMessage.get());
      return;
      if (QMLog.isColorLevel()) {
        QMLog.d("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)bgrm.a().poll();
    } while (paramMessage == null);
    b((bgrm)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrp
 * JD-Core Version:    0.7.0.1
 */
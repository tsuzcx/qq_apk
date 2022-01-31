import android.os.Looper;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.BaseHandler;
import java.util.concurrent.atomic.AtomicInteger;

public final class anig
  implements Runnable
{
  public void run()
  {
    try
    {
      int i = ((Integer)BaseHandler.InitalPriority.get()).intValue();
      int j = Process.getThreadPriority(Process.myTid());
      long l = Thread.currentThread().getId();
      BaseHandler.isRegulated.set(Boolean.valueOf(false));
      BaseHandler.InitalPriority.remove();
      BaseHandler.access$400(i);
      if (BaseHandler.access$400(i)) {}
      for (i = BaseHandler.regulalteCount.decrementAndGet();; i = BaseHandler.regulalteCount.get())
      {
        Looper localLooper = Looper.myLooper();
        if (localLooper != null) {
          localLooper.setMessageLogging(null);
        }
        QLog.i("BaseHandler", 1, "resetPriority ThreadName:" + Thread.currentThread().getName() + "(" + l + ") currentPriority: " + j + ",changed:" + Process.getThreadPriority(Process.myTid()) + " regulated:" + i);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("BaseHandler", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anig
 * JD-Core Version:    0.7.0.1
 */
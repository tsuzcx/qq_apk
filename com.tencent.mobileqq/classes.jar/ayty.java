import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ayty
  extends ThreadPoolExecutor
{
  public ayty(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    if ((paramRunnable instanceof FutureTask)) {}
    try
    {
      ((FutureTask)paramRunnable).get();
      return;
    }
    catch (ExecutionException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GroupSearchEngine", 2, "Exception happened", paramRunnable);
      return;
    }
    catch (Error paramRunnable) {}catch (Exception paramRunnable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayty
 * JD-Core Version:    0.7.0.1
 */
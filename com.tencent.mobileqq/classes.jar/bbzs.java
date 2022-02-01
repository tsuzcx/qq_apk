import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class bbzs
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "SearchTask #" + this.a.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzs
 * JD-Core Version:    0.7.0.1
 */
import java.util.concurrent.ThreadFactory;

class bdjr
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    bdjq.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + bdjq.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjr
 * JD-Core Version:    0.7.0.1
 */
import java.util.concurrent.ThreadFactory;

class bdoa
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    bdnz.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + bdnz.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoa
 * JD-Core Version:    0.7.0.1
 */
import java.util.concurrent.ThreadFactory;

class bbkx
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    bbkw.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + bbkw.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkx
 * JD-Core Version:    0.7.0.1
 */
import java.util.concurrent.ThreadFactory;

class bbkj
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    bbki.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + bbki.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkj
 * JD-Core Version:    0.7.0.1
 */
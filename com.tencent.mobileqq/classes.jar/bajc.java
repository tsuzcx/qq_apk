import java.util.concurrent.ThreadFactory;

class bajc
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    bajb.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + bajb.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajc
 * JD-Core Version:    0.7.0.1
 */
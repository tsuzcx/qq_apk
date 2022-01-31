import java.util.Queue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class bffo
  implements RejectedExecutionHandler
{
  bffo(bffn parambffn) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    bffn.a(this.a).offer(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffo
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import java.util.concurrent.ThreadFactory;

final class dx$1
  implements ThreadFactory
{
  dx$1(dx paramdx) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "locationsdk_network_request_pool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dx.1
 * JD-Core Version:    0.7.0.1
 */
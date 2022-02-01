package c.t.m.g;

import java.util.concurrent.ThreadFactory;

final class ea$1
  implements ThreadFactory
{
  ea$1(ea paramea) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "locationsdk_network_request_pool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.ea.1
 * JD-Core Version:    0.7.0.1
 */
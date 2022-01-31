import android.net.Proxy;
import cooperation.qzone.statistic.access.HttpDeliverer.IProxy;

public final class anhv
  extends HttpDeliverer.IProxy
{
  public int a()
  {
    return Proxy.getDefaultPort();
  }
  
  public String a()
  {
    return Proxy.getDefaultHost();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhv
 * JD-Core Version:    0.7.0.1
 */
import android.net.Proxy;
import cooperation.qzone.QZoneHttpUtil.HttpProxy;

public final class amzd
  extends QZoneHttpUtil.HttpProxy
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
 * Qualified Name:     amzd
 * JD-Core Version:    0.7.0.1
 */
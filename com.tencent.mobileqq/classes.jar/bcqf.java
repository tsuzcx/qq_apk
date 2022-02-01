import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ExceptionTracker.Proxy;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;

public final class bcqf
  implements IMCoreProxyRoute.ExceptionTracker.Proxy
{
  public void trackException(String paramString1, String paramString2)
  {
    ExceptionTracker.trackException(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqf
 * JD-Core Version:    0.7.0.1
 */
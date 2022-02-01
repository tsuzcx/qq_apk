import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator.Proxy;

public final class bcql
  implements IMCoreProxyRoute.ThreadRegulator.Proxy
{
  public void checkInNextBusiness()
  {
    ThreadRegulator.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcql
 * JD-Core Version:    0.7.0.1
 */
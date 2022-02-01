import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper.Proxy;

public final class bdim
  implements IMCoreProxyRoute.ThreadTraceHelper.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    bdlv.b(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    bdlv.a(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    bdlv.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdim
 * JD-Core Version:    0.7.0.1
 */
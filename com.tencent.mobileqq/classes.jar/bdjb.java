import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper.Proxy;

public final class bdjb
  implements IMCoreProxyRoute.ThreadTraceHelper.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    bdmp.b(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    bdmp.a(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    bdmp.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */
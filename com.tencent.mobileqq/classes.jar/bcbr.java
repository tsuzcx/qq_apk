import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper.Proxy;

public final class bcbr
  implements IMCoreProxyRoute.ThreadTraceHelper.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    bcfa.b(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    bcfa.a(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    bcfa.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbr
 * JD-Core Version:    0.7.0.1
 */
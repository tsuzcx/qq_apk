import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper.Proxy;

public final class bcqj
  implements IMCoreProxyRoute.ThreadTraceHelper.Proxy
{
  public void addWaitingTransThread(long paramLong, String paramString)
  {
    bctw.b(paramLong, paramString);
  }
  
  public void removeWaitingTransThread(long paramLong)
  {
    bctw.a(paramLong);
  }
  
  public void setCurrentTransThread(long paramLong, String paramString)
  {
    bctw.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqj
 * JD-Core Version:    0.7.0.1
 */
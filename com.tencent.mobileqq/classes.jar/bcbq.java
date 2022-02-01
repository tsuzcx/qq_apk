import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.SQLiteFTSUtils.Proxy;

public final class bcbq
  implements IMCoreProxyRoute.SQLiteFTSUtils.Proxy
{
  public int getFTSNotifyFlag()
  {
    return bgbo.a(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbq
 * JD-Core Version:    0.7.0.1
 */
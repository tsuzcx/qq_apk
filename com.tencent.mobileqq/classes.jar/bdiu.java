import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.OGEntityDaoManager.Proxy;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public final class bdiu
  implements IMCoreProxyRoute.OGEntityDaoManager.Proxy
{
  public OGAbstractDao getEntityDao(Class paramClass)
  {
    return azny.a().a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiu
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import mqq.app.AppRuntime;

public final class bdit
  implements IMCoreProxyRoute.GetStaticProxy<AppRuntime>
{
  public AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdit
 * JD-Core Version:    0.7.0.1
 */
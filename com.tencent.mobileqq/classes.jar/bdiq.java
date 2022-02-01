import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfoStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopManagerProxy.Proxy;

public final class bdiq
  implements RecentRoute.TroopManagerProxy.Proxy
{
  public TroopInfoStub getTroopInfo(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface))
    {
      paramIMCoreAppRuntime = (TroopManager)paramIMCoreAppRuntime.getManager(52);
      if (paramIMCoreAppRuntime != null) {
        return paramIMCoreAppRuntime.a(paramString, true);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiq
 * JD-Core Version:    0.7.0.1
 */
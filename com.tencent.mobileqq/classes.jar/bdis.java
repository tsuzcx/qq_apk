import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopAssistantManagerProxy.Proxy;

public final class bdis
  implements RecentRoute.TroopAssistantManagerProxy.Proxy
{
  public TroopAssistantData a(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      return axan.a().a((QQAppInterface)paramIMCoreAppRuntime);
    }
    return null;
  }
  
  public int getTroopAssistantUnreadNum(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      return axan.a().a(null, (QQAppInterface)paramIMCoreAppRuntime);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdis
 * JD-Core Version:    0.7.0.1
 */
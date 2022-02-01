import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfoStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.HotChatManagerProxy.Proxy;

public final class bdir
  implements RecentRoute.HotChatManagerProxy.Proxy
{
  public HotChatInfoStub getHotCatInfo(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface))
    {
      paramIMCoreAppRuntime = (HotChatManager)paramIMCoreAppRuntime.getManager(60);
      if (paramIMCoreAppRuntime != null) {
        return paramIMCoreAppRuntime.a(paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdir
 * JD-Core Version:    0.7.0.1
 */
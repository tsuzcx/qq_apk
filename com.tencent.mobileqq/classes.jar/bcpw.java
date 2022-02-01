import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy.Proxy;

public final class bcpw
  implements RecentRoute.ContactUtilsProxy.Proxy
{
  public String getBuddyName(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      str = bglf.b((QQAppInterface)paramIMCoreAppRuntime, paramString, true);
    }
    return str;
  }
  
  public String getTroopName(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {
      str = bglf.a((QQAppInterface)paramIMCoreAppRuntime, paramString, true);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpw
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TalkBack.Proxy;

public final class bdip
  implements IMCoreProxyRoute.TalkBack.Proxy
{
  public boolean getTalkBackStatus()
  {
    return AppSetting.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdip
 * JD-Core Version:    0.7.0.1
 */
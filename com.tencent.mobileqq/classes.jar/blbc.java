import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;

@ProxyService(proxy=WnsConfigProxy.class)
public class blbc
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    List localList = null;
    try
    {
      arfa localarfa = arfb.a();
      if (localarfa != null) {
        localList = localarfa.a();
      }
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbc
 * JD-Core Version:    0.7.0.1
 */
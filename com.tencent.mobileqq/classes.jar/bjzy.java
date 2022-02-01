import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;

@ProxyService(proxy=WnsConfigProxy.class)
public class bjzy
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    List localList = null;
    try
    {
      aqps localaqps = aqpt.a();
      if (localaqps != null) {
        localList = localaqps.a();
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
 * Qualified Name:     bjzy
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.QZonePluginDownloadConfig.1;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Properties;
import mqq.app.AppRuntime;

public class bjoy
  implements IDownloadConfig
{
  private boolean a()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "EnableColor", -1) == 1;
  }
  
  public boolean canRetCodeRetry(int paramInt)
  {
    return false;
  }
  
  public boolean enableDns114()
  {
    return true;
  }
  
  public long getConfig(String paramString1, String paramString2, long paramLong)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong);
  }
  
  public long getCurrentUin()
  {
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      return l;
    }
    catch (Exception localException)
    {
      QLog.w("QzonePluginDownloadConfig", 1, "", localException);
    }
    return 0L;
  }
  
  public long getDefaultHttp2LiveTime()
  {
    return 0L;
  }
  
  public int getDefaultHttp2ThreadPoolSize()
  {
    return 0;
  }
  
  public long getDefaultHttpLiveTime()
  {
    return 0L;
  }
  
  public int getDefaultThreadPoolSize()
  {
    return 0;
  }
  
  public int getNetworkStackType()
  {
    return bjhc.a(1);
  }
  
  public int getOperator()
  {
    int i = zig.a();
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginDownloadConfig", 2, "QzoneDownloadConfig ():WiFiCrarryType=" + i);
    }
    return i;
  }
  
  public String getQUA()
  {
    return bjdm.a();
  }
  
  public String getRefer()
  {
    return "mqq";
  }
  
  public int getReportPercent()
  {
    if (a()) {
      return 100;
    }
    return 5;
  }
  
  public String getTerminal()
  {
    return "Android-QZoneInQQ";
  }
  
  public String getUserAgent()
  {
    return "qzone";
  }
  
  public String getVersion()
  {
    return bjdm.b();
  }
  
  public boolean isFromQzoneAlbum(String paramString)
  {
    return false;
  }
  
  public int photoDownloadKeepAliveConfig()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAlive", 0);
  }
  
  public int photoDownloadKeepAliveProxyConfig()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAliveProxy", 1);
  }
  
  public void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong) {}
  
  public void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2) {}
  
  public void reportToMta(String paramString, Properties paramProperties)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QZonePluginDownloadConfig.1(this, paramString, paramProperties));
  }
  
  public boolean shouldUseHttp2(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjoy
 * JD-Core Version:    0.7.0.1
 */
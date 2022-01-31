import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class amxj
  implements IDownloadConfig
{
  private boolean b()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "EnableColor", -1) == 1;
  }
  
  public int a()
  {
    int i = ExtraConfig.a();
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginDownloadConfig", 2, "QzoneDownloadConfig ():WiFiCrarryType=" + i);
    }
    return i;
  }
  
  public long a()
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
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong);
  }
  
  public String a()
  {
    return QUA.a();
  }
  
  public void a(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean, HashMap paramHashMap, long paramLong) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public int b()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAlive", 0);
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    return "mqq";
  }
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  public int c()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAliveProxy", 1);
  }
  
  public long c()
  {
    return 0L;
  }
  
  public String c()
  {
    return "Android-QZoneInQQ";
  }
  
  public int d()
  {
    if (b()) {
      return 100;
    }
    return 5;
  }
  
  public String d()
  {
    return "qzone";
  }
  
  public int e()
  {
    return 0;
  }
  
  public String e()
  {
    return QUA.b();
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxj
 * JD-Core Version:    0.7.0.1
 */
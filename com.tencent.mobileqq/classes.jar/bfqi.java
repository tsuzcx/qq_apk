import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;

public class bfqi
  extends bfzr
{
  public bfqi(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "[onInstallError] pluginId=" + paramString + ", errorCode=" + paramInt);
    paramString = this.a.a.obtainMessage();
    paramString.what = 1010;
    if (8 == paramInt) {}
    for (paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadErrorNoSpace", "内部存储空间不足，下载失败");; paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadError", "插件下载失败"))
    {
      this.a.a.sendMessage(paramString);
      return;
    }
  }
  
  public void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfqi
 * JD-Core Version:    0.7.0.1
 */
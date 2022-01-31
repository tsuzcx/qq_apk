import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;

public class amdg
  extends OnQZonePluginInstallListner.Stub
{
  private long jdField_a_of_type_Long;
  
  public amdg(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void a(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, "[onInstallBegin] pluginId=" + paramString);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, "[onInstallDownloadProgress] pluginId=" + paramString + " progress=" + paramFloat + " total=" + paramLong);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.w("QzoneVerticalVideoDownloadActivity", 1, "[onInstallError] pluginId=" + paramString + ", errorCode=" + paramInt);
    paramString = QzoneVerticalVideoDownloadActivity.a(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity).obtainMessage();
    paramString.what = 1010;
    if (8 == paramInt) {}
    for (paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadErrorNoSpace", "内部存储空间不足，下载失败");; paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadError", "插件下载失败"))
    {
      QzoneVerticalVideoDownloadActivity.a(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity).sendMessage(paramString);
      return;
    }
  }
  
  public void b(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, "[onInstallFinish] pluginId=" + paramString);
    QzoneVerticalVideoDownloadActivity.a("vertical_layer", "vertical_layer_time_cost", "plugin_install_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdg
 * JD-Core Version:    0.7.0.1
 */
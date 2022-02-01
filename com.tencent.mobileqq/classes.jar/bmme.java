import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.util.VipARUtils.3;

public class bmme
  implements ModuleDownloadListener
{
  public bmme(VipARUtils.3 param3) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("vip_tar_engine.jar")) {
      return;
    }
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bmmb.a(), " onDownloadSucceed = ", bmmb.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bmmb.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmme
 * JD-Core Version:    0.7.0.1
 */
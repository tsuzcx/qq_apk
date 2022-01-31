import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.util.VipARUtils.4;

public class bhyz
  implements ModuleDownloadListener
{
  public bhyz(VipARUtils.4 param4) {}
  
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
    if (!paramString.equals("libTar.so")) {
      return;
    }
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bhyv.c(), " onDownloadSucceed = ", bhyv.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bhyv.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyz
 * JD-Core Version:    0.7.0.1
 */
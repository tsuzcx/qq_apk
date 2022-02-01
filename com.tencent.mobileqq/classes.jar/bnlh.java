import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil.2;

public class bnlh
  implements ModuleDownloadListener
{
  public bnlh(XMPCoreUtil.2 param2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("xmpcore.jar")) {
      return;
    }
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bnlf.a(), " onDownloadSucceed = ", bnlf.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bnlf.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlh
 * JD-Core Version:    0.7.0.1
 */
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

public class amkx
  implements ModuleDownloadListener
{
  public amkx(XMPCoreUtil paramXMPCoreUtil, XMPCoreUtil.XMPCoreJarLoadListener paramXMPCoreJarLoadListener) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    XMPCoreUtil.a(this.jdField_a_of_type_CooperationQzoneUtilXMPCoreUtil, false);
    this.jdField_a_of_type_CooperationQzoneUtilXMPCoreUtil$XMPCoreJarLoadListener.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", XMPCoreUtil.a(), " onDownloadSucceed = ", XMPCoreUtil.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", XMPCoreUtil.b());
    XMPCoreUtil.a(this.jdField_a_of_type_CooperationQzoneUtilXMPCoreUtil);
    this.jdField_a_of_type_CooperationQzoneUtilXMPCoreUtil$XMPCoreJarLoadListener.a(XMPCoreUtil.a(this.jdField_a_of_type_CooperationQzoneUtilXMPCoreUtil));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkx
 * JD-Core Version:    0.7.0.1
 */
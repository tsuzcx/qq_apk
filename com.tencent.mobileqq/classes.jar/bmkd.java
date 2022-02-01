import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bmkd
  implements ModuleDownloadListener
{
  bmkd(bmkc parambmkc, bmkf parambmkf) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bmkc.a(this.jdField_a_of_type_Bmkc, false);
    this.jdField_a_of_type_Bmkf.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bmkc.a(), " onDownloadSucceed = ", bmkc.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bmkc.b());
    bmkc.a(this.jdField_a_of_type_Bmkc);
    this.jdField_a_of_type_Bmkf.a(bmkc.a(this.jdField_a_of_type_Bmkc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkd
 * JD-Core Version:    0.7.0.1
 */
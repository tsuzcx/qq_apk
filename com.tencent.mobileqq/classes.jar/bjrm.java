import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bjrm
  implements ModuleDownloadListener
{
  bjrm(bjrl parambjrl, bjro parambjro) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bjrl.a(this.jdField_a_of_type_Bjrl, false);
    this.jdField_a_of_type_Bjro.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bjrl.a(), " onDownloadSucceed = ", bjrl.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bjrl.b());
    bjrl.a(this.jdField_a_of_type_Bjrl);
    this.jdField_a_of_type_Bjro.a(bjrl.a(this.jdField_a_of_type_Bjrl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrm
 * JD-Core Version:    0.7.0.1
 */
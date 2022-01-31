import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bjvt
  implements ModuleDownloadListener
{
  bjvt(bjvs parambjvs, bjvv parambjvv) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bjvs.a(this.jdField_a_of_type_Bjvs, false);
    this.jdField_a_of_type_Bjvv.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bjvs.a(), " onDownloadSucceed = ", bjvs.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bjvs.b());
    bjvs.a(this.jdField_a_of_type_Bjvs);
    this.jdField_a_of_type_Bjvv.a(bjvs.a(this.jdField_a_of_type_Bjvs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvt
 * JD-Core Version:    0.7.0.1
 */
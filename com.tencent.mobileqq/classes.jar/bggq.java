import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bggq
  implements ModuleDownloadListener
{
  bggq(bggp parambggp, bggs parambggs) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bggp.a(this.jdField_a_of_type_Bggp, false);
    this.jdField_a_of_type_Bggs.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bggp.a(), " onDownloadSucceed = ", bggp.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bggp.b());
    bggp.a(this.jdField_a_of_type_Bggp);
    this.jdField_a_of_type_Bggs.a(bggp.a(this.jdField_a_of_type_Bggp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggq
 * JD-Core Version:    0.7.0.1
 */
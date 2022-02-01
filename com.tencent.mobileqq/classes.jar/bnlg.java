import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bnlg
  implements ModuleDownloadListener
{
  bnlg(bnlf parambnlf, bnli parambnli) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bnlf.a(this.jdField_a_of_type_Bnlf, false);
    this.jdField_a_of_type_Bnli.a(false);
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
    bnlf.a(this.jdField_a_of_type_Bnlf);
    this.jdField_a_of_type_Bnli.a(bnlf.a(this.jdField_a_of_type_Bnlf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlg
 * JD-Core Version:    0.7.0.1
 */
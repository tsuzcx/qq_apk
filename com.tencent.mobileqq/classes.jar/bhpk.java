import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bhpk
  implements ModuleDownloadListener
{
  bhpk(bhpj parambhpj, bhpm parambhpm) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bhpj.a(this.jdField_a_of_type_Bhpj, false);
    this.jdField_a_of_type_Bhpm.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bhpj.a(), " onDownloadSucceed = ", bhpj.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bhpj.b());
    bhpj.a(this.jdField_a_of_type_Bhpj);
    this.jdField_a_of_type_Bhpm.a(bhpj.a(this.jdField_a_of_type_Bhpj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpk
 * JD-Core Version:    0.7.0.1
 */
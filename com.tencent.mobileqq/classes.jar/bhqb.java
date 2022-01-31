import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bhqb
  implements ModuleDownloadListener
{
  bhqb(bhqa parambhqa, bhqd parambhqd) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("XMPCoreUtil", 4, new Object[] { "onDownloadFailed ", paramString });
    bhqa.a(this.jdField_a_of_type_Bhqa, false);
    this.jdField_a_of_type_Bhqd.a(false);
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
    QZLog.i("XMPCoreUtil", 4, new Object[] { "url = ", bhqa.a(), " onDownloadSucceed = ", bhqa.b() });
    LocalMultiProcConfig.putString("xmp_core_file_md5", bhqa.b());
    bhqa.a(this.jdField_a_of_type_Bhqa);
    this.jdField_a_of_type_Bhqd.a(bhqa.a(this.jdField_a_of_type_Bhqa));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqb
 * JD-Core Version:    0.7.0.1
 */
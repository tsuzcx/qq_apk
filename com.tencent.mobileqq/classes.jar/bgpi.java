import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bgpi
  implements ModuleDownloadListener
{
  bgpi(bgph parambgph, bgpm parambgpm) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bgph.a(this.jdField_a_of_type_Bgph, false);
    this.jdField_a_of_type_Bgpm.a(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("vip_tar_engine.jar")) {
      return;
    }
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bgph.a(), " onDownloadSucceed = ", bgph.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bgph.b());
    bgph.a(this.jdField_a_of_type_Bgph);
    this.jdField_a_of_type_Bgpm.a(bgph.a(this.jdField_a_of_type_Bgph));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpi
 * JD-Core Version:    0.7.0.1
 */
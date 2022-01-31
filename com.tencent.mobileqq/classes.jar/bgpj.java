import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bgpj
  implements ModuleDownloadListener
{
  bgpj(bgph parambgph, bgpm parambgpm) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bgph.b(this.jdField_a_of_type_Bgph, false);
    this.jdField_a_of_type_Bgpm.a(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("libTar.so")) {
      return;
    }
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bgph.c(), " onDownloadSucceed = ", bgph.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bgph.d());
    bgph.b(this.jdField_a_of_type_Bgph);
    this.jdField_a_of_type_Bgpm.a(bgph.b(this.jdField_a_of_type_Bgph));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpj
 * JD-Core Version:    0.7.0.1
 */
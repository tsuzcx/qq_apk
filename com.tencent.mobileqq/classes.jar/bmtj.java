import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bmtj
  implements ModuleDownloadListener
{
  bmtj(bmti parambmti, bmtn parambmtn) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bmti.a(this.jdField_a_of_type_Bmti, false);
    this.jdField_a_of_type_Bmtn.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bmti.a(), " onDownloadSucceed = ", bmti.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bmti.b());
    bmti.a(this.jdField_a_of_type_Bmti);
    this.jdField_a_of_type_Bmtn.a(bmti.a(this.jdField_a_of_type_Bmti));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtj
 * JD-Core Version:    0.7.0.1
 */
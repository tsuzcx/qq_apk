import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bmmc
  implements ModuleDownloadListener
{
  bmmc(bmmb parambmmb, bmmg parambmmg) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bmmb.a(this.jdField_a_of_type_Bmmb, false);
    this.jdField_a_of_type_Bmmg.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bmmb.a(), " onDownloadSucceed = ", bmmb.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bmmb.b());
    bmmb.a(this.jdField_a_of_type_Bmmb);
    this.jdField_a_of_type_Bmmg.a(bmmb.a(this.jdField_a_of_type_Bmmb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmc
 * JD-Core Version:    0.7.0.1
 */
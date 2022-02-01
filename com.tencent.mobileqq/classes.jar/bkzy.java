import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bkzy
  implements ModuleDownloadListener
{
  bkzy(bkzx parambkzx, blac paramblac) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bkzx.a(this.jdField_a_of_type_Bkzx, false);
    this.jdField_a_of_type_Blac.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bkzx.a(), " onDownloadSucceed = ", bkzx.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bkzx.b());
    bkzx.a(this.jdField_a_of_type_Bkzx);
    this.jdField_a_of_type_Blac.a(bkzx.a(this.jdField_a_of_type_Bkzx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzy
 * JD-Core Version:    0.7.0.1
 */
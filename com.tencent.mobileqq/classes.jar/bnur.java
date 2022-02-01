import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bnur
  implements ModuleDownloadListener
{
  bnur(bnuq parambnuq, bnuv parambnuv) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bnuq.a(this.jdField_a_of_type_Bnuq, false);
    this.jdField_a_of_type_Bnuv.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bnuq.a(), " onDownloadSucceed = ", bnuq.b() });
    LocalMultiProcConfig.putString("VipARUtils_JAR_md5", bnuq.b());
    bnuq.a(this.jdField_a_of_type_Bnuq);
    this.jdField_a_of_type_Bnuv.a(bnuq.a(this.jdField_a_of_type_Bnuq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnur
 * JD-Core Version:    0.7.0.1
 */
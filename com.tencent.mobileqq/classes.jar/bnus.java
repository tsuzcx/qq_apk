import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bnus
  implements ModuleDownloadListener
{
  bnus(bnuq parambnuq, bnuv parambnuv) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bnuq.b(this.jdField_a_of_type_Bnuq, false);
    this.jdField_a_of_type_Bnuv.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bnuq.c(), " onDownloadSucceed = ", bnuq.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bnuq.d());
    bnuq.b(this.jdField_a_of_type_Bnuq);
    this.jdField_a_of_type_Bnuv.a(bnuq.b(this.jdField_a_of_type_Bnuq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnus
 * JD-Core Version:    0.7.0.1
 */
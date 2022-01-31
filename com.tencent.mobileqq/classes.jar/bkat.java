import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bkat
  implements ModuleDownloadListener
{
  bkat(bkar parambkar, bkaw parambkaw) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bkar.b(this.jdField_a_of_type_Bkar, false);
    this.jdField_a_of_type_Bkaw.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bkar.c(), " onDownloadSucceed = ", bkar.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bkar.d());
    bkar.b(this.jdField_a_of_type_Bkar);
    this.jdField_a_of_type_Bkaw.a(bkar.b(this.jdField_a_of_type_Bkar));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkat
 * JD-Core Version:    0.7.0.1
 */
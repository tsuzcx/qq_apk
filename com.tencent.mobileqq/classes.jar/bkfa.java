import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bkfa
  implements ModuleDownloadListener
{
  bkfa(bkey parambkey, bkfd parambkfd) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bkey.b(this.jdField_a_of_type_Bkey, false);
    this.jdField_a_of_type_Bkfd.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bkey.c(), " onDownloadSucceed = ", bkey.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bkey.d());
    bkey.b(this.jdField_a_of_type_Bkey);
    this.jdField_a_of_type_Bkfd.a(bkey.b(this.jdField_a_of_type_Bkey));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfa
 * JD-Core Version:    0.7.0.1
 */
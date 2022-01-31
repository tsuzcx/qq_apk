import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bhyg
  implements ModuleDownloadListener
{
  bhyg(bhye parambhye, bhyj parambhyj) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bhye.b(this.jdField_a_of_type_Bhye, false);
    this.jdField_a_of_type_Bhyj.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bhye.c(), " onDownloadSucceed = ", bhye.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bhye.d());
    bhye.b(this.jdField_a_of_type_Bhye);
    this.jdField_a_of_type_Bhyj.a(bhye.b(this.jdField_a_of_type_Bhye));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyg
 * JD-Core Version:    0.7.0.1
 */
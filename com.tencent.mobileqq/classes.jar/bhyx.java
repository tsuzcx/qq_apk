import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

class bhyx
  implements ModuleDownloadListener
{
  bhyx(bhyv parambhyv, bhza parambhza) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("VipARUtils", 4, new Object[] { "onDownloadFailed ", paramString });
    bhyv.b(this.jdField_a_of_type_Bhyv, false);
    this.jdField_a_of_type_Bhza.a(false);
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
    QZLog.i("VipARUtils", 4, new Object[] { "url = ", bhyv.c(), " onDownloadSucceed = ", bhyv.d() });
    LocalMultiProcConfig.putString("VipARUtils_SO_md5", bhyv.d());
    bhyv.b(this.jdField_a_of_type_Bhyv);
    this.jdField_a_of_type_Bhza.a(bhyv.b(this.jdField_a_of_type_Bhyv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyx
 * JD-Core Version:    0.7.0.1
 */
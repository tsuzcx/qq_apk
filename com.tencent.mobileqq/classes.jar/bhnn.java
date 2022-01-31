import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

final class bhnn
  implements ModuleDownloadListener
{
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i(bhnm.a, "download webp so fail");
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("animatedWebp.so")) {
      return;
    }
    bdkd.a().edit().putString("PREFERENCE_SO_MD5_KEY", bhnm.b).commit();
    QZLog.i(bhnm.a, "download webp so succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhnn
 * JD-Core Version:    0.7.0.1
 */
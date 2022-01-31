import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

final class bgey
  implements ModuleDownloadListener
{
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i(bgex.a, "download webp so fail");
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("animatedWebp.so")) {
      return;
    }
    bcgc.a().edit().putString("PREFERENCE_SO_MD5_KEY", bgex.b).commit();
    QZLog.i(bgex.a, "download webp so succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgey
 * JD-Core Version:    0.7.0.1
 */
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

final class bjpq
  implements ModuleDownloadListener
{
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i(bjpp.a, "download webp so fail");
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("animatedWebp.so")) {
      return;
    }
    bfjp.a().edit().putString("PREFERENCE_SO_MD5_KEY", bjpp.b).commit();
    QZLog.i(bjpp.a, "download webp so succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpq
 * JD-Core Version:    0.7.0.1
 */
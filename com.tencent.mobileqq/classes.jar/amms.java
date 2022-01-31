import android.os.Bundle;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class amms
  implements WebEventListener
{
  public amms(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      paramString.getInt("totalNum");
      int i = paramString.getInt("successNum");
      int j = paramString.getInt("failNum");
      boolean bool = paramString.getBoolean("isDownloadCanceled");
      paramString = paramString.getString("path");
      QzoneQunFeedJsPlugin.a(this.a, i, j, paramString, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amms
 * JD-Core Version:    0.7.0.1
 */
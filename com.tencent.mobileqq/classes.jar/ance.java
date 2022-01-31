import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class ance
  implements MediaPlayer.OnCompletionListener
{
  public ance(QzoneAudioRecordPlugin paramQzoneAudioRecordPlugin) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QzoneAudioRecordPlugin.a(this.a, null);
    paramMediaPlayer = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("stopped", 1);
      localJSONObject.put("errorcode", 0);
      localJSONObject.put("audioClientKey", QzoneAudioRecordPlugin.a(this.a));
      this.a.a.dispatchJsEvent("QzoneJSBridgeQzoneAudioPlugin_PlayState", localJSONObject, paramMediaPlayer);
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ance
 * JD-Core Version:    0.7.0.1
 */
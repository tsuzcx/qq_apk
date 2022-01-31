import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin;
import cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin.SimpleAACRecorder.RecorderListener;
import org.json.JSONException;
import org.json.JSONObject;

public class ancd
  implements QzoneAudioRecordPlugin.SimpleAACRecorder.RecorderListener
{
  public ancd(QzoneAudioRecordPlugin paramQzoneAudioRecordPlugin) {}
  
  public void a() {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, double paramDouble)
  {
    paramString = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("stopped", 1);
      localJSONObject.put("errorcode", 0);
      localJSONObject.put("audioClientKey", QzoneAudioRecordPlugin.a(this.a));
      this.a.a.dispatchJsEvent("QzoneJSBridgeQzoneAudioPlugin_RecordState", localJSONObject, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QzoneAudioRecordPlugin.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancd
 * JD-Core Version:    0.7.0.1
 */
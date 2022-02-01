import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bnmo
  extends bnnn
{
  public static bnmo a;
  
  public bnmo()
  {
    jdField_a_of_type_Bnmo = this;
  }
  
  public static void a(String paramString)
  {
    if ((jdField_a_of_type_Bnmo != null) && (jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onDeleteAudioVoice");
      jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.moodVoice.onVoiceDelete('" + paramString + "')");
    }
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_Bnmo != null) && (jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onNotifyH5CutCancel");
      jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.moodVoice.cutCancel()");
    }
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_Bnmo != null) && (jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_Bnmo.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZMoodVoiceJSInterface.notifyGetVoiceRecordTime()");
    }
  }
  
  public void a()
  {
    jdField_a_of_type_Bnmo = null;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmo
 * JD-Core Version:    0.7.0.1
 */
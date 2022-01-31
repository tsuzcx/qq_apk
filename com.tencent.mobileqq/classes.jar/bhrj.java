import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bhrj
  extends bhsh
{
  public static bhrj a;
  
  public bhrj()
  {
    jdField_a_of_type_Bhrj = this;
  }
  
  public static void a(String paramString)
  {
    if ((jdField_a_of_type_Bhrj != null) && (jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onDeleteAudioVoice");
      jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.moodVoice.onVoiceDelete('" + paramString + "')");
    }
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_Bhrj != null) && (jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onNotifyH5CutCancel");
      jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.moodVoice.cutCancel()");
    }
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_Bhrj != null) && (jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_Bhrj.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZMoodVoiceJSInterface.notifyGetVoiceRecordTime()");
    }
  }
  
  public void a()
  {
    jdField_a_of_type_Bhrj = null;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrj
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aser
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((!"emoticon".equals(paramString2)) || (("showEmoticon".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      paramString1 = new SearchEmoticonWebBean();
      paramString1.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("emt_name", "");
      paramString1.jdField_b_of_type_JavaLangString = paramJsBridgeListener.optString("emt_oriUrl", "");
      paramString1.jdField_c_of_type_JavaLangString = paramJsBridgeListener.optString("emt_oriMd5", "");
      paramString1.jdField_a_of_type_Int = paramJsBridgeListener.optInt("emt_oriFileSize", 0);
      paramString1.jdField_b_of_type_Int = paramJsBridgeListener.optInt("emt_oriWidth", 0);
      paramString1.jdField_c_of_type_Int = paramJsBridgeListener.optInt("emt_oriHeight", 0);
      paramString1.jdField_d_of_type_Int = paramJsBridgeListener.optInt("emt_type", 0);
      paramString1.jdField_d_of_type_JavaLangString = paramJsBridgeListener.optString("emt_packCoverUrl", "");
      paramString1.e = paramJsBridgeListener.optString("emt_packId", "");
      paramString1.f = paramJsBridgeListener.optString("emt_packName", "");
      paramString1.g = paramJsBridgeListener.optString("emt_miniId", "");
      paramString1.h = paramJsBridgeListener.optString("emt_miniName", "");
      SearchEmoticonFragment.a(this.mRuntime.a(), paramString1);
      bool = true;
      return bool;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPlugin", 2, "showEmoticon error : " + bkgg.a(paramJsBridgeListener));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aser
 * JD-Core Version:    0.7.0.1
 */
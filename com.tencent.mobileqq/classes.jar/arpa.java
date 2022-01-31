import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class arpa
  extends WebViewPlugin
{
  public static final String a;
  protected wxr a;
  
  static
  {
    jdField_a_of_type_JavaLangString = arpa.class.getSimpleName();
  }
  
  public arpa()
  {
    this.mPluginNameSpace = "ftssearch";
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    while ("ftssearch".equals(paramString2)) {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arpa
 * JD-Core Version:    0.7.0.1
 */
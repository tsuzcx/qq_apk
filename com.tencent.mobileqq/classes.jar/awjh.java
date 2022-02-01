import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class awjh
  extends WebViewPlugin
{
  public static final String a;
  protected aasb a;
  
  static
  {
    jdField_a_of_type_JavaLangString = awjh.class.getSimpleName();
  }
  
  public awjh()
  {
    this.mPluginNameSpace = "ftssearch";
    this.jdField_a_of_type_Aasb = aasb.a();
    this.jdField_a_of_type_Aasb.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjh
 * JD-Core Version:    0.7.0.1
 */
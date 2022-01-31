import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class atkd
  extends WebViewPlugin
{
  public static final String a;
  protected yqz a;
  
  static
  {
    jdField_a_of_type_JavaLangString = atkd.class.getSimpleName();
  }
  
  public atkd()
  {
    this.mPluginNameSpace = "ftssearch";
    this.jdField_a_of_type_Yqz = yqz.a();
    this.jdField_a_of_type_Yqz.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkd
 * JD-Core Version:    0.7.0.1
 */
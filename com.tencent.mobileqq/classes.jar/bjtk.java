import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bjtk
  extends bjts
{
  private static void a(WebViewPlugin paramWebViewPlugin, becq parambecq, String[] paramArrayOfString)
  {
    paramWebViewPlugin = new Intent("action_js2qzone");
    paramArrayOfString = new Bundle();
    paramArrayOfString.putString("cmd", "writeBlogSuccess");
    paramWebViewPlugin.putExtras(paramArrayOfString);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneBlogJsPlugin", 2, "handleWriteBlog actionString: " + paramWebViewPlugin.getAction());
    }
    bizm.a(parambecq.a(), bizt.a(), paramWebViewPlugin);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("writeBlogSuccess")) {
      return false;
    }
    a(this.a, this.a.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtk
 * JD-Core Version:    0.7.0.1
 */
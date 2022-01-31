import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bhsi
  extends bhrq
{
  private void a(WebViewPlugin paramWebViewPlugin, bcdb parambcdb, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (parambcdb == null)) {
      return;
    }
    QLog.i("QzoneReactMessageDeliverPlugin", 1, paramArrayOfString[0]);
    paramWebViewPlugin = new Intent("ReactNativeMsgDeliver");
    paramWebViewPlugin.putExtra("args", paramArrayOfString[0]);
    BaseApplication.getContext().sendBroadcast(paramWebViewPlugin);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!"deliverMsg".equalsIgnoreCase(paramString3)) {
      return false;
    }
    a(this.a, this.a.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsi
 * JD-Core Version:    0.7.0.1
 */
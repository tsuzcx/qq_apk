import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class aofg
  extends WebViewPlugin
{
  public aofg()
  {
    this.mPluginNameSpace = "extendFriend";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriend", 2, "handleJsRequest url is: " + paramString1 + " method: " + paramString3 + " pkgName: " + paramString2 + " args: " + paramVarArgs);
    }
    if (!"extendFriend".equals(paramString2)) {}
    while (!"answerResult".equals(paramString3)) {
      return false;
    }
    paramJsBridgeListener = this.mRuntime.a().getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramJsBridgeListener)) {
      aoeu.a(paramJsBridgeListener, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofg
 * JD-Core Version:    0.7.0.1
 */
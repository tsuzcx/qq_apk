import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bgiq
  extends bgix
{
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!"jumpQQCleanPage".equalsIgnoreCase(paramString3)) {
      return false;
    }
    if (this.a.mRuntime.a() != null)
    {
      QQSettingCleanActivity.a(this.a.mRuntime.a());
      return true;
    }
    QLog.e("jumpCleanPage", 2, "call activity with null runtime");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgiq
 * JD-Core Version:    0.7.0.1
 */
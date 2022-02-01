import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

final class bgyc
  implements ValueCallback<String>
{
  bgyc(WebViewFragment paramWebViewFragment) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewUtils", 2, "evaluateJavascript: " + paramString);
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {}
    for (String str = paramString.trim();; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        paramString = str;
        if (str.startsWith("\"")) {
          paramString = str.replaceFirst("\"", "");
        }
        str = paramString;
        if (paramString.endsWith("\"")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        localBundle.putString("banner_wording", String.format(amtj.a(2131713733), new Object[] { str }));
      }
      this.a.goToConversation(localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyc
 * JD-Core Version:    0.7.0.1
 */
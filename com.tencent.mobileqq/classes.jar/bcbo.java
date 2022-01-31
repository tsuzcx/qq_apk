import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bcbo
  extends WebViewPlugin
{
  public bcbo()
  {
    this.mPluginNameSpace = "forceHttps";
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    mvs localmvs = mvs.a();
    boolean bool1 = bool2;
    if (localmvs.e(paramString))
    {
      bool1 = bool2;
      if (!localmvs.f(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!mvs.a().d()) {
      return false;
    }
    if (("http".equals(paramString2)) && (a(paramString1)))
    {
      paramString2 = this.mRuntime.a();
      if ((paramString2 != null) && (paramString2.a != null)) {
        paramString2.a.C = true;
      }
      paramString2 = "https" + paramString1.substring("http".length());
      CustomWebView localCustomWebView = this.mRuntime.a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("need switch url=").append(nau.b(paramString1, new String[0]));
        if (localCustomWebView != null) {
          break label155;
        }
      }
      label155:
      for (paramString1 = ", view==null";; paramString1 = "")
      {
        QLog.i("forceHttps", 2, paramString1);
        if (localCustomWebView == null) {
          break;
        }
        localCustomWebView.loadUrl(paramString2);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcbo
 * JD-Core Version:    0.7.0.1
 */
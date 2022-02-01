import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class bimv
  extends WebViewPlugin
{
  public bimv()
  {
    this.mPluginNameSpace = "forceHttps";
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    niz localniz = niz.a();
    boolean bool1 = bool2;
    if (localniz.e(paramString))
    {
      bool1 = bool2;
      if (!localniz.f(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!niz.a().d()) {
      return false;
    }
    if (("http".equals(paramString2)) && (a(paramString1)))
    {
      paramString2 = this.mRuntime.a();
      if ((paramString2 != null) && (paramString2.mStatistics != null)) {
        paramString2.mStatistics.C = true;
      }
      paramString2 = "https" + paramString1.substring("http".length());
      CustomWebView localCustomWebView = this.mRuntime.a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("need switch url=").append(noe.b(paramString1, new String[0]));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimv
 * JD-Core Version:    0.7.0.1
 */
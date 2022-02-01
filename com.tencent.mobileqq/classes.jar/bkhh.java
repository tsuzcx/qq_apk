import android.content.Context;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import cooperation.comic.webbundle.WebBundleWebView;
import org.jetbrains.annotations.NotNull;

public class bkhh
  extends IWebBundleRuntime
{
  public bkhh(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  @NotNull
  public IWebBundleWebView createWebView(@NotNull Context paramContext)
  {
    paramContext = new WebBundleWebView(paramContext);
    WebSettings localWebSettings = paramContext.getSettings();
    String str = localWebSettings.getUserAgentString();
    if (paramContext.getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localWebSettings.setUserAgentString(bgyb.a(str, "VipComic", bool));
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhh
 * JD-Core Version:    0.7.0.1
 */
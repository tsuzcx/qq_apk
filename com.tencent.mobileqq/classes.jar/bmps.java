import android.text.TextUtils;
import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bmps
  implements ReaderJsCallback
{
  bmps(bmpr parambmpr) {}
  
  public void onCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      bmpr.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    if (paramReaderBaseWebViewPlugin != null) {
      paramReaderBaseWebViewPlugin.init(this.a.mRuntime, bmpr.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmps
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bmfi
  implements ReaderJsCallback
{
  bmfi(bmfh parambmfh) {}
  
  public void onCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      bmfh.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    if (paramReaderBaseWebViewPlugin != null) {
      paramReaderBaseWebViewPlugin.init(this.a.mRuntime, bmfh.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfi
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bguz
  implements ReaderJsCallback
{
  bguz(bguy parambguy) {}
  
  public void onCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      bguy.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    if (paramReaderBaseWebViewPlugin != null) {
      paramReaderBaseWebViewPlugin.init(this.a.mRuntime, bguy.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguz
 * JD-Core Version:    0.7.0.1
 */
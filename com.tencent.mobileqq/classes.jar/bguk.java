import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bguk
  implements ReaderJsCallback
{
  bguk(bgui parambgui) {}
  
  public void onCallback(String paramString1, String paramString2) {}
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    paramReaderBaseWebViewPlugin.init(bgui.a(this.a), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguk
 * JD-Core Version:    0.7.0.1
 */
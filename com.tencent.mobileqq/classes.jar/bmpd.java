import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bmpd
  implements ReaderJsCallback
{
  bmpd(bmpb parambmpb) {}
  
  public void onCallback(String paramString1, String paramString2) {}
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    paramReaderBaseWebViewPlugin.init(bmpb.a(this.a), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpd
 * JD-Core Version:    0.7.0.1
 */
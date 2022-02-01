import cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin;
import cooperation.qqreader.proxy.ReaderJsCallback;

class bktk
  implements ReaderJsCallback
{
  bktk(bkti parambkti) {}
  
  public void onCallback(String paramString1, String paramString2) {}
  
  public void onInitPluginCallBack(ReaderBaseWebViewPlugin paramReaderBaseWebViewPlugin)
  {
    paramReaderBaseWebViewPlugin.init(bkti.a(this.a), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktk
 * JD-Core Version:    0.7.0.1
 */
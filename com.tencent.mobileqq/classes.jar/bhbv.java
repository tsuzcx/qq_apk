import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer.6;
import com.tencent.smtt.sdk.ValueCallback;

public class bhbv
  implements ValueCallback<String>
{
  public bhbv(PageWebviewContainer.6 param6) {}
  
  public void a(String paramString)
  {
    QMLog.d("PageWebviewContainer", "openFileReader callback  : " + paramString);
    if ((paramString != null) && (paramString.startsWith("http"))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).downloadQQBrowser("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbv
 * JD-Core Version:    0.7.0.1
 */
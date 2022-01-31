import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;

public class anbx
  implements Runnable
{
  public anbx(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime) {}
  
  public void run()
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getContext(), "抱歉，你未安装微信客户端，无法进行微信分享", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbx
 * JD-Core Version:    0.7.0.1
 */
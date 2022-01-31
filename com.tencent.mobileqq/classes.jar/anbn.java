import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;
import cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin;

public class anbn
  implements QzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  public anbn(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin.a != null)
    {
      String str = "window." + this.jdField_a_of_type_JavaLangString + "({playFinish:1})";
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin.a.callJs(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbn
 * JD-Core Version:    0.7.0.1
 */
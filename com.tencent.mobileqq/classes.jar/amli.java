import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;
import cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin;

public class amli
  implements QzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  public amli(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String paramString) {}
  
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
 * Qualified Name:     amli
 * JD-Core Version:    0.7.0.1
 */
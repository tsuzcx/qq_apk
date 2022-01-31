import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;
import cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin;

public class amlm
  implements QzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  public amlm(QZonePassivePraiseJsPlugin paramQZonePassivePraiseJsPlugin, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQZonePassivePraiseJsPlugin.a != null)
    {
      String str = "window." + this.jdField_a_of_type_JavaLangString + "({playAnimationFinish:1})";
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZonePassivePraiseJsPlugin.a.callJs(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlm
 * JD-Core Version:    0.7.0.1
 */
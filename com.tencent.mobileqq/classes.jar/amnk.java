import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.share.WXShareFromQZHelper;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import cooperation.qzone.webviewplugin.QzoneWidgetAIJsPlugin;

public class amnk
  implements Runnable
{
  public amnk(QzoneWidgetAIJsPlugin paramQzoneWidgetAIJsPlugin, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    WXShareFromQZHelper localWXShareFromQZHelper2;
    if ((1 == this.jdField_a_of_type_Int) || (2 == this.jdField_a_of_type_Int))
    {
      localWXShareFromQZHelper2 = WXShareFromQZHelper.a();
      localWXShareFromQZHelper1 = localWXShareFromQZHelper2;
      if (localWXShareFromQZHelper2 == null)
      {
        localWXShareFromQZHelper1 = localWXShareFromQZHelper2;
        if (localWXShareFromQZHelper2.a()) {
          WXShareFromQZHelper.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneWidgetAIJsPlugin.a.mRuntime.a());
        }
      }
    }
    for (WXShareFromQZHelper localWXShareFromQZHelper1 = localWXShareFromQZHelper2;; localWXShareFromQZHelper1 = null)
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        localWXShareFromQZHelper1.a(this.jdField_a_of_type_JavaLangString, null, 0);
        return;
      case 2: 
        localWXShareFromQZHelper1.a(this.jdField_a_of_type_JavaLangString, null, 1);
        return;
      case 3: 
        QzoneLiveVideoInterface.shareToQQ(localActivity, null, null, null, null, this.jdField_a_of_type_JavaLangString);
        return;
      }
      QZoneHelper.a(localActivity, QZoneHelper.UserInfo.a(), this.jdField_a_of_type_JavaLangString, "说说", this.b, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnk
 * JD-Core Version:    0.7.0.1
 */
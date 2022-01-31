import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;

public class anka
  implements Runnable
{
  public anka(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin.a != null) && (this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin.a.mRuntime != null)) {
        QQToast.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin.a.mRuntime.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0).a();
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.w("QZoneSharePictureJsPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anka
 * JD-Core Version:    0.7.0.1
 */
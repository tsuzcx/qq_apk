import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;

public class anbs
  implements Runnable
{
  public anbs(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (AlbumLibDownloaderUtil.a().a(AlbumLibDownloaderUtil.a, true))
    {
      QZoneSharePictureJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin, this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin.a.mRuntime, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    QZoneSharePictureJsPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneSharePictureJsPlugin, this.jdField_a_of_type_ArrayOfJavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbs
 * JD-Core Version:    0.7.0.1
 */
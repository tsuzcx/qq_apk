import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class bgie
  implements Downloader.DownloadListener
{
  bgie(bgic parambgic, String[] paramArrayOfString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "onDownloadCanceled");
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.w("QZoneSharePictureJsPlugin", "下载GIF组件失败，请稍后重试");
    bgic.a(this.jdField_a_of_type_Bgic, ajjy.a(2131646542), 1);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "下载GIF组件成功");
    if (this.jdField_a_of_type_Bgic.a != null)
    {
      bgic.a(this.jdField_a_of_type_Bgic, this.jdField_a_of_type_Bgic.a.mRuntime, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    QZLog.w("QZoneSharePictureJsPlugin", "parentPlugin is null");
    bgic.a(this.jdField_a_of_type_Bgic, ajjy.a(2131646521), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgie
 * JD-Core Version:    0.7.0.1
 */
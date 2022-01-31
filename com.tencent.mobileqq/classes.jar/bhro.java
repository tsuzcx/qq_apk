import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class bhro
  implements Downloader.DownloadListener
{
  bhro(bhrm parambhrm, String[] paramArrayOfString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "onDownloadCanceled");
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.w("QZoneSharePictureJsPlugin", "下载GIF组件失败，请稍后重试");
    bhrm.a(this.jdField_a_of_type_Bhrm, ajya.a(2131712341), 1);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "下载GIF组件成功");
    if (this.jdField_a_of_type_Bhrm.a != null)
    {
      bhrm.a(this.jdField_a_of_type_Bhrm, this.jdField_a_of_type_Bhrm.a.mRuntime, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    QZLog.w("QZoneSharePictureJsPlugin", "parentPlugin is null");
    bhrm.a(this.jdField_a_of_type_Bhrm, ajya.a(2131712320), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhro
 * JD-Core Version:    0.7.0.1
 */
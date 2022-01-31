import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;

class bjxg
  implements Downloader.DownloadListener
{
  bjxg(bjxe parambjxe, String[] paramArrayOfString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "onDownloadCanceled");
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.w("QZoneSharePictureJsPlugin", "下载GIF组件失败，请稍后重试");
    bjxe.a(this.jdField_a_of_type_Bjxe, alud.a(2131712725), 1);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("QZoneSharePictureJsPlugin", "下载GIF组件成功");
    if (this.jdField_a_of_type_Bjxe.a != null)
    {
      bjxe.a(this.jdField_a_of_type_Bjxe, this.jdField_a_of_type_Bjxe.a.mRuntime, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    QZLog.w("QZoneSharePictureJsPlugin", "parentPlugin is null");
    bjxe.a(this.jdField_a_of_type_Bjxe, alud.a(2131712704), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxg
 * JD-Core Version:    0.7.0.1
 */
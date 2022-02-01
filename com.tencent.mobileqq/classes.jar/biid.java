import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import java.lang.ref.WeakReference;

public class biid
  implements TbsDownloader.TbsDownloaderCallback
{
  WeakReference<WebViewFragment> a;
  
  public biid(WebViewFragment paramWebViewFragment)
  {
    this.a = new WeakReference(paramWebViewFragment);
  }
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QbSdk.setUploadCode(BaseApplication.getContext(), 156);
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs need download");
      }
      if ((this.a != null) && (this.a.get() != null)) {
        ((WebViewFragment)this.a.get()).browserApp.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biid
 * JD-Core Version:    0.7.0.1
 */
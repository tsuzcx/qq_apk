import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

class beeu
  implements TbsDownloader.TbsDownloaderCallback
{
  beeu(beet parambeet) {}
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QbSdk.setUploadCode(BaseApplication.getContext(), 156);
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs need download");
      }
      this.a.a.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeu
 * JD-Core Version:    0.7.0.1
 */
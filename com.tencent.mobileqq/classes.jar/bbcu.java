import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import java.lang.ref.WeakReference;

final class bbcu
  implements TbsDownloader.TbsDownloaderCallback
{
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (bbcs.a != null))
    {
      BrowserAppInterface localBrowserAppInterface = (BrowserAppInterface)bbcs.a.get();
      if (localBrowserAppInterface != null)
      {
        localBrowserAppInterface.a(false);
        QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on callback:download tbs.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbcu
 * JD-Core Version:    0.7.0.1
 */
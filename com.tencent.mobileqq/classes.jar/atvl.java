import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

final class atvl
  implements SDKInitListener
{
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("FileVideoDownloadManager<FileAssistant>XOXO", 1, "initSDKAsync failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */
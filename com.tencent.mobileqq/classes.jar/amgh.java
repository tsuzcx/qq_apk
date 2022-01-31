import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleDownloadManager;
import java.util.Map;

public class amgh
  implements Downloader.DownloadListener
{
  public amgh(QzoneModuleDownloadManager paramQzoneModuleDownloadManager) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Message localMessage = Message.obtain(QzoneModuleDownloadManager.a(this.a));
    localMessage.what = 5;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(QzoneModuleDownloadManager.a(this.a));
    paramDownloadResult.what = 3;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = (amgi)QzoneModuleDownloadManager.a(this.a).get(paramString);
    if (paramString != null) {
      paramString.a = Float.valueOf(paramFloat);
    }
    Message localMessage = Message.obtain(QzoneModuleDownloadManager.a(this.a));
    localMessage.what = 6;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(QzoneModuleDownloadManager.a(this.a));
    paramDownloadResult.what = 2;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgh
 * JD-Core Version:    0.7.0.1
 */
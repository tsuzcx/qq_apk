import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Map;

class bjmp
  implements Downloader.DownloadListener
{
  bjmp(bjmo parambjmo) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Message localMessage = Message.obtain(bjmo.a(this.a));
    localMessage.what = 5;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(bjmo.a(this.a));
    paramDownloadResult.what = 3;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = (bjmq)bjmo.a(this.a).get(paramString);
    if (paramString != null) {
      paramString.a = Float.valueOf(paramFloat);
    }
    Message localMessage = Message.obtain(bjmo.a(this.a));
    localMessage.what = 6;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramDownloadResult = Message.obtain(bjmo.a(this.a));
    paramDownloadResult.what = 2;
    paramDownloadResult.obj = paramString;
    paramDownloadResult.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmp
 * JD-Core Version:    0.7.0.1
 */
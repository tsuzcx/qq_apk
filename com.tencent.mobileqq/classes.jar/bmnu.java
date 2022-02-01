import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public final class bmnu
  implements ThreadPool.Job<Object>
{
  public bmnu(String paramString1, String paramString2) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    QzoneZipCacheHelper.access$100().a(QzoneZipCacheHelper.access$100().a(QzoneZipCacheHelper.access$000(this.a, this.b)), true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnu
 * JD-Core Version:    0.7.0.1
 */
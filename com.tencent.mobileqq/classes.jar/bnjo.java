import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.concurrent.CountDownLatch;

public final class bnjo
  implements Downloader.DownloadListener
{
  public bnjo(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void onDownloadCanceled(String paramString)
  {
    this.jdField_a_of_type_ArrayOfBoolean[0] = false;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    this.jdField_a_of_type_ArrayOfBoolean[0] = false;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    this.jdField_a_of_type_ArrayOfBoolean[0] = true;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjo
 * JD-Core Version:    0.7.0.1
 */
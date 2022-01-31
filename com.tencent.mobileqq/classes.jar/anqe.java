import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import cooperation.weiyun.sdk.download.WyDownloader;
import java.util.Iterator;
import java.util.List;

public class anqe
  implements ThreadPool.Job
{
  public anqe(WyDownloader paramWyDownloader, List paramList) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader.b(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqe
 * JD-Core Version:    0.7.0.1
 */
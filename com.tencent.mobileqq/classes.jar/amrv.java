import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import cooperation.weiyun.sdk.download.WyDownloader;
import java.util.Iterator;
import java.util.List;

public class amrv
  implements ThreadPool.Job
{
  public amrv(WyDownloader paramWyDownloader, List paramList) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader.a(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrv
 * JD-Core Version:    0.7.0.1
 */
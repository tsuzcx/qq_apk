import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.WyDownloader;
import java.util.HashMap;

public class anqb
  implements ThreadPool.Job
{
  public anqb(WyDownloader paramWyDownloader, Long paramLong, NetReq paramNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (DownloadJobContext)WyDownloader.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader).get(this.jdField_a_of_type_JavaLangLong);
    if ((paramJobContext == null) || (paramJobContext.d())) {
      WyDownloader.a(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader, this.jdField_a_of_type_JavaLangLong.longValue());
    }
    for (;;)
    {
      return null;
      WyDownloader.b(this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader).a(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqb
 * JD-Core Version:    0.7.0.1
 */
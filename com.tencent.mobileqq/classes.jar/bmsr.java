import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;

class bmsr
  implements ThreadPool.Job<Void>
{
  bmsr(bmsl parambmsl, HttpNetReq paramHttpNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    bmsl.a(this.jdField_a_of_type_Bmsl).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsr
 * JD-Core Version:    0.7.0.1
 */
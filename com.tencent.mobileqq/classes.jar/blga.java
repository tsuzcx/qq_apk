import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;

class blga
  implements ThreadPool.Job<Void>
{
  blga(blfu paramblfu, HttpNetReq paramHttpNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    blfu.a(this.jdField_a_of_type_Blfu).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blga
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashMap;

class blgb
  implements ThreadPool.Job<Void>
{
  blgb(blfu paramblfu, Long paramLong, NetReq paramNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (blfr)blfu.a(this.jdField_a_of_type_Blfu).get(this.jdField_a_of_type_JavaLangLong);
    if ((paramJobContext == null) || (paramJobContext.d())) {
      blfu.a(this.jdField_a_of_type_Blfu, this.jdField_a_of_type_JavaLangLong.longValue());
    }
    for (;;)
    {
      return null;
      blfu.b(this.jdField_a_of_type_Blfu).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgb
 * JD-Core Version:    0.7.0.1
 */
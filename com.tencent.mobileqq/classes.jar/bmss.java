import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.HashMap;

class bmss
  implements ThreadPool.Job<Void>
{
  bmss(bmsl parambmsl, Long paramLong, NetReq paramNetReq) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = (bmsi)bmsl.a(this.jdField_a_of_type_Bmsl).get(this.jdField_a_of_type_JavaLangLong);
    if ((paramJobContext == null) || (paramJobContext.d())) {
      bmsl.a(this.jdField_a_of_type_Bmsl, this.jdField_a_of_type_JavaLangLong.longValue());
    }
    for (;;)
    {
      return null;
      bmsl.b(this.jdField_a_of_type_Bmsl).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmss
 * JD-Core Version:    0.7.0.1
 */
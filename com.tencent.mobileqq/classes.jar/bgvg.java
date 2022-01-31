import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.Iterator;
import java.util.List;

class bgvg
  implements ThreadPool.Job<Void>
{
  bgvg(bguw parambguw, List paramList) {}
  
  public Void a(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramJobContext.hasNext())
    {
      long l = ((Long)paramJobContext.next()).longValue();
      this.jdField_a_of_type_Bguw.b(l);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvg
 * JD-Core Version:    0.7.0.1
 */
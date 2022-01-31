import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bjdv
  implements ThreadPool.Job<Object>
{
  bjdv(bjdu parambjdu, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bjdu.a(this.jdField_a_of_type_Bjdu).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bjds localbjds = (bjds)paramJobContext.next();
        int j = localbjds.a(this.jdField_a_of_type_Boolean);
        String str = localbjds.a();
        int i = bjdu.a(this.jdField_a_of_type_Bjdu, str);
        j = bjdu.a(this.jdField_a_of_type_Bjdu, j, i);
        this.jdField_a_of_type_Bjdu.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbjds + ": remain=" + j);
      }
      if (bjdu.a(bjdq.p()))
      {
        bjdq.a(false);
        if (bjdu.a(bjdq.p()))
        {
          bjdq.a(true);
          bjdu.a(this.jdField_a_of_type_Bjdu);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjdv
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bjic
  implements ThreadPool.Job<Object>
{
  bjic(bjib parambjib, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bjib.a(this.jdField_a_of_type_Bjib).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bjhz localbjhz = (bjhz)paramJobContext.next();
        int j = localbjhz.a(this.jdField_a_of_type_Boolean);
        String str = localbjhz.a();
        int i = bjib.a(this.jdField_a_of_type_Bjib, str);
        j = bjib.a(this.jdField_a_of_type_Bjib, j, i);
        this.jdField_a_of_type_Bjib.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbjhz + ": remain=" + j);
      }
      if (bjib.a(bjhx.p()))
      {
        bjhx.a(false);
        if (bjib.a(bjhx.p()))
        {
          bjhx.a(true);
          bjib.a(this.jdField_a_of_type_Bjib);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjic
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class blwk
  implements ThreadPool.Job<Object>
{
  blwk(blwj paramblwj, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = blwj.a(this.jdField_a_of_type_Blwj).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        blwh localblwh = (blwh)paramJobContext.next();
        int j = localblwh.a(this.jdField_a_of_type_Boolean);
        String str = localblwh.a();
        int i = blwj.a(this.jdField_a_of_type_Blwj, str);
        j = blwj.a(this.jdField_a_of_type_Blwj, j, i);
        this.jdField_a_of_type_Blwj.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localblwh + ": remain=" + j);
      }
      if (blwj.a(blwf.p()))
      {
        blwf.a(false);
        if (blwj.a(blwf.p()))
        {
          blwf.a(true);
          blwj.a(this.jdField_a_of_type_Blwj);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwk
 * JD-Core Version:    0.7.0.1
 */
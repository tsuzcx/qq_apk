import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bhbu
  implements ThreadPool.Job<Object>
{
  bhbu(bhbt parambhbt, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bhbt.a(this.jdField_a_of_type_Bhbt).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bhbr localbhbr = (bhbr)paramJobContext.next();
        int j = localbhbr.a(this.jdField_a_of_type_Boolean);
        String str = localbhbr.a();
        int i = bhbt.a(this.jdField_a_of_type_Bhbt, str);
        j = bhbt.a(this.jdField_a_of_type_Bhbt, j, i);
        this.jdField_a_of_type_Bhbt.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbhbr + ": remain=" + j);
      }
      if (bhbt.a(bhbp.p()))
      {
        bhbp.a(false);
        if (bhbt.a(bhbp.p()))
        {
          bhbp.a(true);
          bhbt.a(this.jdField_a_of_type_Bhbt);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbu
 * JD-Core Version:    0.7.0.1
 */
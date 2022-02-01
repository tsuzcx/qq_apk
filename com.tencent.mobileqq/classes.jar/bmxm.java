import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bmxm
  implements ThreadPool.Job<Object>
{
  bmxm(bmxl parambmxl, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bmxl.a(this.jdField_a_of_type_Bmxl).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bmxj localbmxj = (bmxj)paramJobContext.next();
        int j = localbmxj.a(this.jdField_a_of_type_Boolean);
        String str = localbmxj.a();
        int i = bmxl.a(this.jdField_a_of_type_Bmxl, str);
        j = bmxl.a(this.jdField_a_of_type_Bmxl, j, i);
        this.jdField_a_of_type_Bmxl.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbmxj + ": remain=" + j);
      }
      if (bmxl.a(bmxh.p()))
      {
        bmxh.a(false);
        if (bmxl.a(bmxh.p()))
        {
          bmxh.a(true);
          bmxl.a(this.jdField_a_of_type_Bmxl);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxm
 * JD-Core Version:    0.7.0.1
 */
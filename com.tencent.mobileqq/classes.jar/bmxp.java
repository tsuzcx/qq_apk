import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bmxp
  implements ThreadPool.Job<Object>
{
  bmxp(bmxl parambmxl, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bmxl.a(this.jdField_a_of_type_Bmxl).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bmxj)paramJobContext.next();
        int i = ((bmxj)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bmxj)localObject).a();
        this.jdField_a_of_type_Bmxl.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxp
 * JD-Core Version:    0.7.0.1
 */
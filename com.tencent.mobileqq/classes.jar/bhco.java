import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bhco
  implements ThreadPool.Job<Object>
{
  bhco(bhck parambhck, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bhck.a(this.jdField_a_of_type_Bhck).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bhci)paramJobContext.next();
        int i = ((bhci)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bhci)localObject).a();
        this.jdField_a_of_type_Bhck.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhco
 * JD-Core Version:    0.7.0.1
 */
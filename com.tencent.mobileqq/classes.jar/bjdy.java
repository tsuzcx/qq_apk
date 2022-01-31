import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bjdy
  implements ThreadPool.Job<Object>
{
  bjdy(bjdu parambjdu, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bjdu.a(this.jdField_a_of_type_Bjdu).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bjds)paramJobContext.next();
        int i = ((bjds)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bjds)localObject).a();
        this.jdField_a_of_type_Bjdu.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjdy
 * JD-Core Version:    0.7.0.1
 */
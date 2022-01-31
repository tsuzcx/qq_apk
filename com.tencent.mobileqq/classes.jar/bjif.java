import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bjif
  implements ThreadPool.Job<Object>
{
  bjif(bjib parambjib, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bjib.a(this.jdField_a_of_type_Bjib).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bjhz)paramJobContext.next();
        int i = ((bjhz)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bjhz)localObject).a();
        this.jdField_a_of_type_Bjib.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjif
 * JD-Core Version:    0.7.0.1
 */
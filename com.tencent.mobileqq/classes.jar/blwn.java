import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class blwn
  implements ThreadPool.Job<Object>
{
  blwn(blwj paramblwj, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = blwj.a(this.jdField_a_of_type_Blwj).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (blwh)paramJobContext.next();
        int i = ((blwh)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((blwh)localObject).a();
        this.jdField_a_of_type_Blwj.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwn
 * JD-Core Version:    0.7.0.1
 */
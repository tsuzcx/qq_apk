import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bhbx
  implements ThreadPool.Job<Object>
{
  bhbx(bhbt parambhbt, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bhbt.a(this.jdField_a_of_type_Bhbt).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bhbr)paramJobContext.next();
        int i = ((bhbr)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bhbr)localObject).a();
        this.jdField_a_of_type_Bhbt.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbx
 * JD-Core Version:    0.7.0.1
 */
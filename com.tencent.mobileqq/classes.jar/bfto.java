import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class bfto
  implements ThreadPool.Job<Object>
{
  bfto(bftk parambftk, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bftk.a(this.jdField_a_of_type_Bftk).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        Object localObject = (bfti)paramJobContext.next();
        int i = ((bfti)localObject).a(this.jdField_a_of_type_Boolean);
        localObject = ((bfti)localObject).a();
        this.jdField_a_of_type_Bftk.a((String)localObject, i);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfto
 * JD-Core Version:    0.7.0.1
 */
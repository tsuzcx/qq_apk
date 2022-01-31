import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bhcl
  implements ThreadPool.Job<Object>
{
  bhcl(bhck parambhck, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bhck.a(this.jdField_a_of_type_Bhck).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bhci localbhci = (bhci)paramJobContext.next();
        int j = localbhci.a(this.jdField_a_of_type_Boolean);
        String str = localbhci.a();
        int i = bhck.a(this.jdField_a_of_type_Bhck, str);
        j = bhck.a(this.jdField_a_of_type_Bhck, j, i);
        this.jdField_a_of_type_Bhck.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbhci + ": remain=" + j);
      }
      if (bhck.a(bhcg.p()))
      {
        bhcg.a(false);
        if (bhck.a(bhcg.p()))
        {
          bhcg.a(true);
          bhck.a(this.jdField_a_of_type_Bhck);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhcl
 * JD-Core Version:    0.7.0.1
 */
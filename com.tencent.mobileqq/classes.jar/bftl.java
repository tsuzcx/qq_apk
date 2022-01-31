import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

class bftl
  implements ThreadPool.Job<Object>
{
  bftl(bftk parambftk, boolean paramBoolean) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = bftk.a(this.jdField_a_of_type_Bftk).a();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      while (paramJobContext.hasNext())
      {
        bfti localbfti = (bfti)paramJobContext.next();
        int j = localbfti.a(this.jdField_a_of_type_Boolean);
        String str = localbfti.a();
        int i = bftk.a(this.jdField_a_of_type_Bftk, str);
        j = bftk.a(this.jdField_a_of_type_Bftk, j, i);
        this.jdField_a_of_type_Bftk.a(i, j, str);
        QLog.w("CacheManager", 1, "onLowStorage clear cache service:" + localbfti + ": remain=" + j);
      }
      if (bftk.a(bftg.p()))
      {
        bftg.a(false, true);
        if (bftk.a(bftg.p()))
        {
          bftg.a(true, true);
          bftk.a(this.jdField_a_of_type_Bftk);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bftl
 * JD-Core Version:    0.7.0.1
 */
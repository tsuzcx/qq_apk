import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class apbg
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final apdj jdField_a_of_type_Apdj;
  private final apdk<apbq> jdField_a_of_type_Apdk;
  private final List<apbq> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public apbg(apdj paramapdj, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Apdj = paramapdj;
    this.jdField_a_of_type_Apdk = new apdk(paramDanmakuComparator, new apbh(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<apbq> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      apbq localapbq = (apbq)paramList.get(i);
      if (localapbq.d() <= this.jdField_a_of_type_Long) {
        localapbq.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      apds.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      apds.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Apdk.a();
  }
  
  public apbq a()
  {
    return (apbq)this.jdField_a_of_type_Apdk.a();
  }
  
  public List<apbq> a()
  {
    c();
    this.jdField_a_of_type_Apdk.a(this.jdField_a_of_type_Apdj.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    apds.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Apdk.a();
    d();
  }
  
  public void a(apbq paramapbq)
  {
    c();
    apds.c("DanmakuDataSource", "addNow: danmaku = " + paramapbq);
    this.jdField_a_of_type_Apdk.b(paramapbq);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Apdk != null) && (this.jdField_a_of_type_Apdk.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    apbq localapbq = (apbq)this.jdField_a_of_type_Apdk.b();
    if (localapbq == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localapbq.d())
    {
      d();
      return;
    }
  }
  
  public void b(apbq paramapbq)
  {
    c();
    apds.c("DanmakuDataSource", "addLast: danmaku = " + paramapbq);
    this.jdField_a_of_type_Apdk.a(paramapbq);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbg
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class anfq
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final anht jdField_a_of_type_Anht;
  private final anhu<anga> jdField_a_of_type_Anhu;
  private final List<anga> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public anfq(anht paramanht, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Anht = paramanht;
    this.jdField_a_of_type_Anhu = new anhu(paramDanmakuComparator, new anfr(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<anga> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      anga localanga = (anga)paramList.get(i);
      if (localanga.d() <= this.jdField_a_of_type_Long) {
        localanga.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      anic.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      anic.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Anhu.a();
  }
  
  public anga a()
  {
    return (anga)this.jdField_a_of_type_Anhu.a();
  }
  
  public List<anga> a()
  {
    c();
    this.jdField_a_of_type_Anhu.a(this.jdField_a_of_type_Anht.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    anic.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Anhu.a();
    d();
  }
  
  public void a(anga paramanga)
  {
    c();
    anic.c("DanmakuDataSource", "addNow: danmaku = " + paramanga);
    this.jdField_a_of_type_Anhu.b(paramanga);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Anhu != null) && (this.jdField_a_of_type_Anhu.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    anga localanga = (anga)this.jdField_a_of_type_Anhu.b();
    if (localanga == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localanga.d())
    {
      d();
      return;
    }
  }
  
  public void b(anga paramanga)
  {
    c();
    anic.c("DanmakuDataSource", "addLast: danmaku = " + paramanga);
    this.jdField_a_of_type_Anhu.a(paramanga);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfq
 * JD-Core Version:    0.7.0.1
 */
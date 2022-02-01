import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqnq
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final aqpt jdField_a_of_type_Aqpt;
  private final aqpu<aqoa> jdField_a_of_type_Aqpu;
  private final List<aqoa> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public aqnq(aqpt paramaqpt, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Aqpt = paramaqpt;
    this.jdField_a_of_type_Aqpu = new aqpu(paramDanmakuComparator, new aqnr(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<aqoa> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aqoa localaqoa = (aqoa)paramList.get(i);
      if (localaqoa.d() <= this.jdField_a_of_type_Long) {
        localaqoa.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      aqqb.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      aqqb.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aqpu.a();
  }
  
  public aqoa a()
  {
    return (aqoa)this.jdField_a_of_type_Aqpu.a();
  }
  
  public List<aqoa> a()
  {
    c();
    this.jdField_a_of_type_Aqpu.a(this.jdField_a_of_type_Aqpt.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    aqqb.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Aqpu.a();
    d();
  }
  
  public void a(aqoa paramaqoa)
  {
    c();
    aqqb.c("DanmakuDataSource", "addNow: danmaku = " + paramaqoa);
    this.jdField_a_of_type_Aqpu.b(paramaqoa);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Aqpu != null) && (this.jdField_a_of_type_Aqpu.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    aqoa localaqoa = (aqoa)this.jdField_a_of_type_Aqpu.b();
    if (localaqoa == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localaqoa.d())
    {
      d();
      return;
    }
  }
  
  public void b(aqoa paramaqoa)
  {
    c();
    aqqb.c("DanmakuDataSource", "addLast: danmaku = " + paramaqoa);
    this.jdField_a_of_type_Aqpu.a(paramaqoa);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnq
 * JD-Core Version:    0.7.0.1
 */
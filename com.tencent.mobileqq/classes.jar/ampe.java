import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ampe
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final amrh jdField_a_of_type_Amrh;
  private final amri<ampo> jdField_a_of_type_Amri;
  private final List<ampo> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public ampe(amrh paramamrh, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Amrh = paramamrh;
    this.jdField_a_of_type_Amri = new amri(paramDanmakuComparator, new ampf(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<ampo> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ampo localampo = (ampo)paramList.get(i);
      if (localampo.d() <= this.jdField_a_of_type_Long) {
        localampo.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      amrq.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      amrq.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Amri.a();
  }
  
  public ampo a()
  {
    return (ampo)this.jdField_a_of_type_Amri.a();
  }
  
  public List<ampo> a()
  {
    c();
    this.jdField_a_of_type_Amri.a(this.jdField_a_of_type_Amrh.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    amrq.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Amri.a();
    d();
  }
  
  public void a(ampo paramampo)
  {
    c();
    amrq.c("DanmakuDataSource", "addNow: danmaku = " + paramampo);
    this.jdField_a_of_type_Amri.b(paramampo);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Amri != null) && (this.jdField_a_of_type_Amri.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    ampo localampo = (ampo)this.jdField_a_of_type_Amri.b();
    if (localampo == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localampo.d())
    {
      d();
      return;
    }
  }
  
  public void b(ampo paramampo)
  {
    c();
    amrq.c("DanmakuDataSource", "addLast: danmaku = " + paramampo);
    this.jdField_a_of_type_Amri.a(paramampo);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampe
 * JD-Core Version:    0.7.0.1
 */
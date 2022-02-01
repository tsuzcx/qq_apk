import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class arts
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final arvv jdField_a_of_type_Arvv;
  private final arvw<aruc> jdField_a_of_type_Arvw;
  private final List<aruc> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public arts(arvv paramarvv, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Arvv = paramarvv;
    this.jdField_a_of_type_Arvw = new arvw(paramDanmakuComparator, new artt(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<aruc> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aruc localaruc = (aruc)paramList.get(i);
      if (localaruc.d() <= this.jdField_a_of_type_Long) {
        localaruc.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      arwe.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      arwe.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Arvw.a();
  }
  
  public aruc a()
  {
    return (aruc)this.jdField_a_of_type_Arvw.a();
  }
  
  public List<aruc> a()
  {
    c();
    this.jdField_a_of_type_Arvw.a(this.jdField_a_of_type_Arvv.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    arwe.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Arvw.a();
    d();
  }
  
  public void a(aruc paramaruc)
  {
    c();
    arwe.c("DanmakuDataSource", "addNow: danmaku = " + paramaruc);
    this.jdField_a_of_type_Arvw.b(paramaruc);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Arvw != null) && (this.jdField_a_of_type_Arvw.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    aruc localaruc = (aruc)this.jdField_a_of_type_Arvw.b();
    if (localaruc == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localaruc.d())
    {
      d();
      return;
    }
  }
  
  public void b(aruc paramaruc)
  {
    c();
    arwe.c("DanmakuDataSource", "addLast: danmaku = " + paramaruc);
    this.jdField_a_of_type_Arvw.a(paramaruc);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arts
 * JD-Core Version:    0.7.0.1
 */
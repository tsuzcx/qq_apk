import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ared
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final argg jdField_a_of_type_Argg;
  private final argh<aren> jdField_a_of_type_Argh;
  private final List<aren> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public ared(argg paramargg, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Argg = paramargg;
    this.jdField_a_of_type_Argh = new argh(paramDanmakuComparator, new aree(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<aren> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aren localaren = (aren)paramList.get(i);
      if (localaren.d() <= this.jdField_a_of_type_Long) {
        localaren.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      argp.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      argp.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Argh.a();
  }
  
  public aren a()
  {
    return (aren)this.jdField_a_of_type_Argh.a();
  }
  
  public List<aren> a()
  {
    c();
    this.jdField_a_of_type_Argh.a(this.jdField_a_of_type_Argg.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    argp.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Argh.a();
    d();
  }
  
  public void a(aren paramaren)
  {
    c();
    argp.c("DanmakuDataSource", "addNow: danmaku = " + paramaren);
    this.jdField_a_of_type_Argh.b(paramaren);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Argh != null) && (this.jdField_a_of_type_Argh.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    aren localaren = (aren)this.jdField_a_of_type_Argh.b();
    if (localaren == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localaren.d())
    {
      d();
      return;
    }
  }
  
  public void b(aren paramaren)
  {
    c();
    argp.c("DanmakuDataSource", "addLast: danmaku = " + paramaren);
    this.jdField_a_of_type_Argh.a(paramaren);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ared
 * JD-Core Version:    0.7.0.1
 */
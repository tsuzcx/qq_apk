import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class arrb
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final arte jdField_a_of_type_Arte;
  private final artf<arrl> jdField_a_of_type_Artf;
  private final List<arrl> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public arrb(arte paramarte, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Arte = paramarte;
    this.jdField_a_of_type_Artf = new artf(paramDanmakuComparator, new arrc(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<arrl> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      arrl localarrl = (arrl)paramList.get(i);
      if (localarrl.d() <= this.jdField_a_of_type_Long) {
        localarrl.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      artm.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      artm.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Artf.a();
  }
  
  public arrl a()
  {
    return (arrl)this.jdField_a_of_type_Artf.a();
  }
  
  public List<arrl> a()
  {
    c();
    this.jdField_a_of_type_Artf.a(this.jdField_a_of_type_Arte.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    artm.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Artf.a();
    d();
  }
  
  public void a(arrl paramarrl)
  {
    c();
    artm.c("DanmakuDataSource", "addNow: danmaku = " + paramarrl);
    this.jdField_a_of_type_Artf.b(paramarrl);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Artf != null) && (this.jdField_a_of_type_Artf.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    arrl localarrl = (arrl)this.jdField_a_of_type_Artf.b();
    if (localarrl == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localarrl.d())
    {
      d();
      return;
    }
  }
  
  public void b(arrl paramarrl)
  {
    c();
    artm.c("DanmakuDataSource", "addLast: danmaku = " + paramarrl);
    this.jdField_a_of_type_Artf.a(paramarrl);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrb
 * JD-Core Version:    0.7.0.1
 */
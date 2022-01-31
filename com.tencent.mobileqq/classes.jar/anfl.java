import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class anfl
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final anho jdField_a_of_type_Anho;
  private final anhp<anfv> jdField_a_of_type_Anhp;
  private final List<anfv> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public anfl(anho paramanho, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Anho = paramanho;
    this.jdField_a_of_type_Anhp = new anhp(paramDanmakuComparator, new anfm(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<anfv> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      anfv localanfv = (anfv)paramList.get(i);
      if (localanfv.d() <= this.jdField_a_of_type_Long) {
        localanfv.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      anhx.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      anhx.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Anhp.a();
  }
  
  public anfv a()
  {
    return (anfv)this.jdField_a_of_type_Anhp.a();
  }
  
  public List<anfv> a()
  {
    c();
    this.jdField_a_of_type_Anhp.a(this.jdField_a_of_type_Anho.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    anhx.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Anhp.a();
    d();
  }
  
  public void a(anfv paramanfv)
  {
    c();
    anhx.c("DanmakuDataSource", "addNow: danmaku = " + paramanfv);
    this.jdField_a_of_type_Anhp.b(paramanfv);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Anhp != null) && (this.jdField_a_of_type_Anhp.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    anfv localanfv = (anfv)this.jdField_a_of_type_Anhp.b();
    if (localanfv == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localanfv.d())
    {
      d();
      return;
    }
  }
  
  public void b(anfv paramanfv)
  {
    c();
    anhx.c("DanmakuDataSource", "addLast: danmaku = " + paramanfv);
    this.jdField_a_of_type_Anhp.a(paramanfv);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfl
 * JD-Core Version:    0.7.0.1
 */
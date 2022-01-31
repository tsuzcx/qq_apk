import com.tencent.mobileqq.danmaku.core.DanmakuManager.DanmakuComparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aowx
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final aoza jdField_a_of_type_Aoza;
  private final aozb<aoxh> jdField_a_of_type_Aozb;
  private final List<aoxh> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public aowx(aoza paramaoza, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_Aoza = paramaoza;
    this.jdField_a_of_type_Aozb = new aozb(paramDanmakuComparator, new aowy(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<aoxh> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      aoxh localaoxh = (aoxh)paramList.get(i);
      if (localaoxh.d() <= this.jdField_a_of_type_Long) {
        localaoxh.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      aozj.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      aozj.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aozb.a();
  }
  
  public aoxh a()
  {
    return (aoxh)this.jdField_a_of_type_Aozb.a();
  }
  
  public List<aoxh> a()
  {
    c();
    this.jdField_a_of_type_Aozb.a(this.jdField_a_of_type_Aoza.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    aozj.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_Aozb.a();
    d();
  }
  
  public void a(aoxh paramaoxh)
  {
    c();
    aozj.c("DanmakuDataSource", "addNow: danmaku = " + paramaoxh);
    this.jdField_a_of_type_Aozb.b(paramaoxh);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_Aozb != null) && (this.jdField_a_of_type_Aozb.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    aoxh localaoxh = (aoxh)this.jdField_a_of_type_Aozb.b();
    if (localaoxh == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localaoxh.d())
    {
      d();
      return;
    }
  }
  
  public void b(aoxh paramaoxh)
  {
    c();
    aozj.c("DanmakuDataSource", "addLast: danmaku = " + paramaoxh);
    this.jdField_a_of_type_Aozb.a(paramaoxh);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowx
 * JD-Core Version:    0.7.0.1
 */
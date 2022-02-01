import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ancg
{
  private ancc jdField_a_of_type_Ancc;
  private ancl jdField_a_of_type_Ancl;
  private CopyOnWriteArrayList<anbu> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ancg(ancc paramancc, ancl paramancl)
  {
    this.jdField_a_of_type_Ancl = paramancl;
    this.jdField_a_of_type_Ancc = paramancc;
  }
  
  public anbu a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      anbu localanbu = (anbu)localIterator.next();
      if (localanbu.b() == paramInt) {
        return localanbu;
      }
    }
    return null;
  }
  
  public anbu a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ancc == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      }
    }
    for (localObject = new anca(paramInt1, paramInt2, this.jdField_a_of_type_Ancc); (localObject != null) && (((anbu)localObject).a()); localObject = new anbt(paramInt1, this.jdField_a_of_type_Ancc))
    {
      ((anbu)localObject).d();
      ((anbu)localObject).a(this.jdField_a_of_type_Ancl);
      ((anbu)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ancc == null) {}
    anbu localanbu;
    do
    {
      return;
      if (this.jdField_a_of_type_Ancc.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localanbu = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localanbu == null) || (!(localanbu instanceof anbt)) || ((anbt)localanbu != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((anbu)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancg
 * JD-Core Version:    0.7.0.1
 */
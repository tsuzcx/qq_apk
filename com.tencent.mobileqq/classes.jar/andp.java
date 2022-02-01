import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class andp
{
  private ancl jdField_a_of_type_Ancl;
  private ande jdField_a_of_type_Ande;
  private andi jdField_a_of_type_Andi;
  private CopyOnWriteArrayList<andg> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public andp(andi paramandi, ancl paramancl, ande paramande)
  {
    this.jdField_a_of_type_Ancl = paramancl;
    this.jdField_a_of_type_Andi = paramandi;
    this.jdField_a_of_type_Ande = paramande;
  }
  
  public andg a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      andg localandg = (andg)localIterator.next();
      if (localandg.b() == paramInt) {
        return localandg;
      }
    }
    return null;
  }
  
  public andg a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Andi == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("CmShow_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      default: 
        localObject = new andh(paramInt1, paramInt2, this.jdField_a_of_type_Andi, this.jdField_a_of_type_Ande);
      }
    }
    while ((localObject != null) && (((andg)localObject).a()))
    {
      ((andg)localObject).d();
      ((andg)localObject).a(this.jdField_a_of_type_Ancl);
      ((andg)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new andf(paramInt1, this.jdField_a_of_type_Andi, this.jdField_a_of_type_Ande);
      continue;
      localObject = new andf(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Andi, this.jdField_a_of_type_Ande);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Andi == null) {
      return;
    }
    if (this.jdField_a_of_type_Andi.a() == null)
    {
      QLog.w("CmShow_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
      return;
    }
    a(100, -1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((andg)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andp
 * JD-Core Version:    0.7.0.1
 */
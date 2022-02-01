import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class anhn
{
  private angj jdField_a_of_type_Angj;
  private anhc jdField_a_of_type_Anhc;
  private anhg jdField_a_of_type_Anhg;
  private CopyOnWriteArrayList<anhe> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public anhn(anhg paramanhg, angj paramangj, anhc paramanhc)
  {
    this.jdField_a_of_type_Angj = paramangj;
    this.jdField_a_of_type_Anhg = paramanhg;
    this.jdField_a_of_type_Anhc = paramanhc;
  }
  
  public anhe a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      anhe localanhe = (anhe)localIterator.next();
      if (localanhe.b() == paramInt) {
        return localanhe;
      }
    }
    return null;
  }
  
  public anhe a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Anhg == null) {
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
        localObject = new anhf(paramInt1, paramInt2, this.jdField_a_of_type_Anhg, this.jdField_a_of_type_Anhc);
      }
    }
    while ((localObject != null) && (((anhe)localObject).a()))
    {
      ((anhe)localObject).d();
      ((anhe)localObject).a(this.jdField_a_of_type_Angj);
      ((anhe)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new anhd(paramInt1, this.jdField_a_of_type_Anhg, this.jdField_a_of_type_Anhc);
      continue;
      localObject = new anhd(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Anhg, this.jdField_a_of_type_Anhc);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anhg == null) {
      return;
    }
    if (this.jdField_a_of_type_Anhg.a() == null)
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
      ((anhe)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */
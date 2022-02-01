import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class amch
{
  private ambd jdField_a_of_type_Ambd;
  private ambw jdField_a_of_type_Ambw;
  private amca jdField_a_of_type_Amca;
  private CopyOnWriteArrayList<amby> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public amch(amca paramamca, ambd paramambd, ambw paramambw)
  {
    this.jdField_a_of_type_Ambd = paramambd;
    this.jdField_a_of_type_Amca = paramamca;
    this.jdField_a_of_type_Ambw = paramambw;
  }
  
  public amby a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      amby localamby = (amby)localIterator.next();
      if (localamby.b() == paramInt) {
        return localamby;
      }
    }
    return null;
  }
  
  public amby a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Amca == null) {
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
        localObject = new ambz(paramInt1, paramInt2, this.jdField_a_of_type_Amca, this.jdField_a_of_type_Ambw);
      }
    }
    while ((localObject != null) && (((amby)localObject).a()))
    {
      ((amby)localObject).d();
      ((amby)localObject).a(this.jdField_a_of_type_Ambd);
      ((amby)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new ambx(paramInt1, this.jdField_a_of_type_Amca, this.jdField_a_of_type_Ambw);
      continue;
      localObject = new ambx(paramInt1, "cmshow_base.js", this.jdField_a_of_type_Amca, this.jdField_a_of_type_Ambw);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amca == null) {
      return;
    }
    if (this.jdField_a_of_type_Amca.a() == null)
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
      ((amby)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amch
 * JD-Core Version:    0.7.0.1
 */
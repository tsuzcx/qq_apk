import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ange
{
  private anga jdField_a_of_type_Anga;
  private angj jdField_a_of_type_Angj;
  private CopyOnWriteArrayList<anfs> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public ange(anga paramanga, angj paramangj)
  {
    this.jdField_a_of_type_Angj = paramangj;
    this.jdField_a_of_type_Anga = paramanga;
  }
  
  public anfs a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      anfs localanfs = (anfs)localIterator.next();
      if (localanfs.b() == paramInt) {
        return localanfs;
      }
    }
    return null;
  }
  
  public anfs a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Anga == null) {
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
    for (localObject = new anfy(paramInt1, paramInt2, this.jdField_a_of_type_Anga); (localObject != null) && (((anfs)localObject).a()); localObject = new anfr(paramInt1, this.jdField_a_of_type_Anga))
    {
      ((anfs)localObject).d();
      ((anfs)localObject).a(this.jdField_a_of_type_Angj);
      ((anfs)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anga == null) {}
    anfs localanfs;
    do
    {
      return;
      if (this.jdField_a_of_type_Anga.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localanfs = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localanfs == null) || (!(localanfs instanceof anfr)) || ((anfr)localanfs != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((anfs)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ange
 * JD-Core Version:    0.7.0.1
 */
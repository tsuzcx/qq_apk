import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public abstract class anqt<T extends CustomEmotionBase>
  implements Manager
{
  protected QQAppInterface a;
  protected String a;
  protected CopyOnWriteArrayList<WeakReference<antf>> a;
  protected AtomicBoolean a;
  
  public anqt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  protected abstract int a();
  
  protected abstract ajul<T> a();
  
  protected abstract anqr<T> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a(antf paramantf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramantf) {
        return;
      }
    }
    paramantf = new WeakReference(paramantf);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramantf);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajul localajul;
    do
    {
      return;
      localajul = a();
    } while (localajul == null);
    if (QLog.isColorLevel()) {
      QLog.d("CustomEmotionRoamingManagerBase", 2, "------------start syncRoaming----------");
    }
    localajul.a();
  }
  
  public void b(antf paramantf)
  {
    if (paramantf == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramantf);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anqt
 * JD-Core Version:    0.7.0.1
 */
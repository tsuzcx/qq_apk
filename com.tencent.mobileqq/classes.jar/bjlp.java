import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class bjlp
{
  private ArrayList<bjlq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  
  public bjlq a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    bjlq localbjlq;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localbjlq = (bjlq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbjlq.a != paramLong) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return localbjlq;
      i += 1;
      break;
      localbjlq = null;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((bjlq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a == paramLong) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public void a(long paramLong, Context paramContext)
  {
    if (a(paramLong) != null) {
      return;
    }
    paramContext = new bjlq(this);
    paramContext.a = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjlp
 * JD-Core Version:    0.7.0.1
 */
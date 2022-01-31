import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class bedp
{
  private ArrayList<bedq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  
  public bedq a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    bedq localbedq;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localbedq = (bedq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbedq.a != paramLong) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return localbedq;
      i += 1;
      break;
      localbedq = null;
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
        if (((bedq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a == paramLong) {
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
    paramContext = new bedq(this);
    paramContext.a = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bedp
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class bkxa
{
  private ArrayList<bkxb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  
  public bkxb a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    bkxb localbkxb;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localbkxb = (bkxb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localbkxb.a != paramLong) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return localbkxb;
      i += 1;
      break;
      localbkxb = null;
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
        if (((bkxb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a == paramLong) {
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
    paramContext = new bkxb(this);
    paramContext.a = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxa
 * JD-Core Version:    0.7.0.1
 */
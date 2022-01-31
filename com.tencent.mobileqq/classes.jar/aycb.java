import com.tencent.mobileqq.data.MessageForScribble;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class aycb
{
  public final int a;
  private ArrayList<aybz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private PriorityBlockingQueue<aybz> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public final int b = 0;
  public final int c = 1;
  public final int d = 2;
  public final int e = 0;
  public final int f = -1;
  
  aycb(ayca paramayca)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      ayca.a(this.jdField_a_of_type_Ayca, "getDownloadingSize", "downing size is " + i);
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(aybz paramaybz)
  {
    int k = 1;
    int m = -1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (paramaybz.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq == ((aybz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              j = 1;
              i = 1;
              if ((j == 0) && (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0))
              {
                Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
                if (localIterator.hasNext())
                {
                  aybz localaybz = (aybz)localIterator.next();
                  if (localaybz.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq != paramaybz.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq) {
                    continue;
                  }
                  if (localaybz.jdField_a_of_type_Int >= paramaybz.jdField_a_of_type_Int) {
                    break label214;
                  }
                  localaybz.jdField_a_of_type_Int = paramaybz.jdField_a_of_type_Int;
                  break label214;
                  if (j == 0)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramaybz);
                    i = 0;
                  }
                  return i;
                }
              }
            }
            else
            {
              i += 1;
              continue;
            }
            continue;
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      int j = 0;
      int i = m;
      continue;
      label214:
      i = 2;
      j = k;
    }
  }
  
  public int a(MessageForScribble paramMessageForScribble)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (paramMessageForScribble.uniseq == ((aybz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              this.jdField_a_of_type_JavaUtilArrayList.remove(i);
              i = 0;
              return i;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public aybz a()
  {
    aybz localaybz = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
      {
        localaybz = (aybz)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        this.jdField_a_of_type_JavaUtilArrayList.add(localaybz);
      }
      return localaybz;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycb
 * JD-Core Version:    0.7.0.1
 */
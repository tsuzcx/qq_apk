import com.tencent.mobileqq.data.MessageForScribble;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class awgx
{
  public final int a;
  private ArrayList<awgv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private PriorityBlockingQueue<awgv> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public final int b = 0;
  public final int c = 1;
  public final int d = 2;
  public final int e = 0;
  public final int f = -1;
  
  awgx(awgw paramawgw)
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
      awgw.a(this.jdField_a_of_type_Awgw, "getDownloadingSize", "downing size is " + i);
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(awgv paramawgv)
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
            if (paramawgv.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq == ((awgv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              j = 1;
              i = 1;
              if ((j == 0) && (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0))
              {
                Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
                if (localIterator.hasNext())
                {
                  awgv localawgv = (awgv)localIterator.next();
                  if (localawgv.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq != paramawgv.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq) {
                    continue;
                  }
                  if (localawgv.jdField_a_of_type_Int >= paramawgv.jdField_a_of_type_Int) {
                    break label214;
                  }
                  localawgv.jdField_a_of_type_Int = paramawgv.jdField_a_of_type_Int;
                  break label214;
                  if (j == 0)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramawgv);
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
            if (paramMessageForScribble.uniseq == ((awgv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
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
  
  public awgv a()
  {
    awgv localawgv = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
      {
        localawgv = (awgv)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        this.jdField_a_of_type_JavaUtilArrayList.add(localawgv);
      }
      return localawgv;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgx
 * JD-Core Version:    0.7.0.1
 */
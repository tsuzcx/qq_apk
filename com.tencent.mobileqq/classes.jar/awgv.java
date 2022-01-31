import com.tencent.mobileqq.data.MessageForScribble;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class awgv
{
  public final int a;
  private ArrayList<awgt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private PriorityBlockingQueue<awgt> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public final int b = 0;
  public final int c = 1;
  public final int d = 2;
  public final int e = 0;
  public final int f = -1;
  
  awgv(awgu paramawgu)
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
      awgu.a(this.jdField_a_of_type_Awgu, "getDownloadingSize", "downing size is " + i);
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(awgt paramawgt)
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
            if (paramawgt.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq == ((awgt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
            {
              j = 1;
              i = 1;
              if ((j == 0) && (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0))
              {
                Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
                if (localIterator.hasNext())
                {
                  awgt localawgt = (awgt)localIterator.next();
                  if (localawgt.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq != paramawgt.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq) {
                    continue;
                  }
                  if (localawgt.jdField_a_of_type_Int >= paramawgt.jdField_a_of_type_Int) {
                    break label214;
                  }
                  localawgt.jdField_a_of_type_Int = paramawgt.jdField_a_of_type_Int;
                  break label214;
                  if (j == 0)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(paramawgt);
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
            if (paramMessageForScribble.uniseq == ((awgt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.uniseq)
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
  
  public awgt a()
  {
    awgt localawgt = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.size() > 0)
      {
        localawgt = (awgt)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        this.jdField_a_of_type_JavaUtilArrayList.add(localawgt);
      }
      return localawgt;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgv
 * JD-Core Version:    0.7.0.1
 */
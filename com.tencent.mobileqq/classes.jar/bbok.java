import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class bbok
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private CopyOnWriteArrayList<Integer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(10);
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(10);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()))
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        i = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0)).intValue();
        if (!QLog.isColorLevel()) {
          break label160;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext())
        {
          int j = ((Integer)localIterator.next()).intValue();
          localStringBuilder.append(j + ",");
        }
      }
      QLog.d("PeakAudioTransHandler ChannelStateManager", 2, "getRecentTopEvent lastevent = " + i + "， eventlist = " + localObject2.toString());
      label160:
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      return i;
    }
    return -1;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, Integer.valueOf(paramInt));
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 12;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 11;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 10;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 13;
  }
  
  public boolean h()
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    int j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    switch (i)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if ((!bool1) && (QLog.isColorLevel())) {
        QLog.e("PeakAudioTransHandler ChannelStateManager", 2, "isLegalState , currentSessionState = " + i + " currentTCPState = " + j);
      }
      return bool1;
      switch (j)
      {
      }
      for (bool1 = false;; bool1 = false) {
        break;
      }
      bool1 = bool2;
      switch (j)
      {
      case 11: 
      case 12: 
      case 13: 
      default: 
        bool1 = bool2;
        break;
      case 10: 
        bool1 = true;
        continue;
        bool1 = bool3;
        switch (j)
        {
        default: 
          bool1 = false;
        }
        continue;
        bool1 = bool2;
        switch (j)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          bool1 = bool2;
          break;
        case 10: 
          bool1 = true;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbok
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bcoa
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bcob> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bcob> jdField_b_of_type_JavaUtilList = new Vector();
  
  bcoa()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FilterableObservable-bg-thread");
      localHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void a(bcob parambcob, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambcob, paramInt, paramVarArgs));
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.getLooper().quit();
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
      return;
    }
    finally {}
  }
  
  public void a(bcob parambcob)
  {
    if (parambcob != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambcob);
      this.jdField_b_of_type_JavaUtilList.remove(parambcob);
      return;
    }
    finally
    {
      parambcob = finally;
      throw parambcob;
    }
  }
  
  public void a(bcob parambcob, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambcob);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambcob);
    }
  }
  
  public void a(Class<? extends bcob> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bcob localbcob;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbcob = (bcob)localIterator.next();
        if ((paramClass != null) && (localbcob != null) && (paramClass.isAssignableFrom(localbcob.getClass()))) {
          a(localbcob, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbcob = (bcob)localIterator.next();
        if ((paramClass != null) && (localbcob != null) && (paramClass.isAssignableFrom(localbcob.getClass()))) {
          a(localbcob, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcoa
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bdsb
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bdsc> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bdsc> jdField_b_of_type_JavaUtilList = new Vector();
  
  bdsb()
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
  
  private void a(bdsc parambdsc, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambdsc, paramInt, paramVarArgs));
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
  
  public void a(bdsc parambdsc)
  {
    if (parambdsc != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambdsc);
      this.jdField_b_of_type_JavaUtilList.remove(parambdsc);
      return;
    }
    finally
    {
      parambdsc = finally;
      throw parambdsc;
    }
  }
  
  public void a(bdsc parambdsc, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambdsc);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambdsc);
    }
  }
  
  public void a(Class<? extends bdsc> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bdsc localbdsc;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbdsc = (bdsc)localIterator.next();
        if ((paramClass != null) && (localbdsc != null) && (paramClass.isAssignableFrom(localbdsc.getClass()))) {
          a(localbdsc, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbdsc = (bdsc)localIterator.next();
        if ((paramClass != null) && (localbdsc != null) && (paramClass.isAssignableFrom(localbdsc.getClass()))) {
          a(localbdsc, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsb
 * JD-Core Version:    0.7.0.1
 */
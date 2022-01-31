import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bdsq
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bdsr> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bdsr> jdField_b_of_type_JavaUtilList = new Vector();
  
  bdsq()
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
  
  private void a(bdsr parambdsr, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambdsr, paramInt, paramVarArgs));
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
  
  public void a(bdsr parambdsr)
  {
    if (parambdsr != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambdsr);
      this.jdField_b_of_type_JavaUtilList.remove(parambdsr);
      return;
    }
    finally
    {
      parambdsr = finally;
      throw parambdsr;
    }
  }
  
  public void a(bdsr parambdsr, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambdsr);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambdsr);
    }
  }
  
  public void a(Class<? extends bdsr> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bdsr localbdsr;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbdsr = (bdsr)localIterator.next();
        if ((paramClass != null) && (localbdsr != null) && (paramClass.isAssignableFrom(localbdsr.getClass()))) {
          a(localbdsr, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbdsr = (bdsr)localIterator.next();
        if ((paramClass != null) && (localbdsr != null) && (paramClass.isAssignableFrom(localbdsr.getClass()))) {
          a(localbdsr, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsq
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bkdw
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bkdx> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bkdx> jdField_b_of_type_JavaUtilList = new Vector();
  
  bkdw()
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
  
  private void a(bkdx parambkdx, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambkdx, paramInt, paramVarArgs));
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
  
  public void a(bkdx parambkdx)
  {
    if (parambkdx != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambkdx);
      this.jdField_b_of_type_JavaUtilList.remove(parambkdx);
      return;
    }
    finally
    {
      parambkdx = finally;
      throw parambkdx;
    }
  }
  
  public void a(bkdx parambkdx, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambkdx);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambkdx);
    }
  }
  
  public void a(Class<? extends bkdx> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bkdx localbkdx;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbkdx = (bkdx)localIterator.next();
        if ((paramClass != null) && (localbkdx != null) && (paramClass.isAssignableFrom(localbkdx.getClass()))) {
          a(localbkdx, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbkdx = (bkdx)localIterator.next();
        if ((paramClass != null) && (localbkdx != null) && (paramClass.isAssignableFrom(localbkdx.getClass()))) {
          a(localbkdx, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdw
 * JD-Core Version:    0.7.0.1
 */
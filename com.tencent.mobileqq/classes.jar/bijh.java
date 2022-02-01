import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bijh
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<biji> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<biji> jdField_b_of_type_JavaUtilList = new Vector();
  
  bijh()
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
  
  private void a(biji parambiji, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambiji, paramInt, paramVarArgs));
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
  
  public void a(biji parambiji)
  {
    if (parambiji != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambiji);
      this.jdField_b_of_type_JavaUtilList.remove(parambiji);
      return;
    }
    finally
    {
      parambiji = finally;
      throw parambiji;
    }
  }
  
  public void a(biji parambiji, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambiji);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambiji);
    }
  }
  
  public void a(Class<? extends biji> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    biji localbiji;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbiji = (biji)localIterator.next();
        if ((paramClass != null) && (localbiji != null) && (paramClass.isAssignableFrom(localbiji.getClass()))) {
          a(localbiji, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbiji = (biji)localIterator.next();
        if ((paramClass != null) && (localbiji != null) && (paramClass.isAssignableFrom(localbiji.getClass()))) {
          a(localbiji, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bijh
 * JD-Core Version:    0.7.0.1
 */
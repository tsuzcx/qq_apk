import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bfvw
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bfvx> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bfvx> jdField_b_of_type_JavaUtilList = new Vector();
  
  bfvw()
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
  
  private void a(bfvx parambfvx, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambfvx, paramInt, paramVarArgs));
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
  
  public void a(bfvx parambfvx)
  {
    if (parambfvx != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambfvx);
      this.jdField_b_of_type_JavaUtilList.remove(parambfvx);
      return;
    }
    finally
    {
      parambfvx = finally;
      throw parambfvx;
    }
  }
  
  public void a(bfvx parambfvx, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambfvx);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambfvx);
    }
  }
  
  public void a(Class<? extends bfvx> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bfvx localbfvx;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbfvx = (bfvx)localIterator.next();
        if ((paramClass != null) && (localbfvx != null) && (paramClass.isAssignableFrom(localbfvx.getClass()))) {
          a(localbfvx, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbfvx = (bfvx)localIterator.next();
        if ((paramClass != null) && (localbfvx != null) && (paramClass.isAssignableFrom(localbfvx.getClass()))) {
          a(localbfvx, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvw
 * JD-Core Version:    0.7.0.1
 */
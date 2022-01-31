import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bfrn
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bfro> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bfro> jdField_b_of_type_JavaUtilList = new Vector();
  
  bfrn()
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
  
  private void a(bfro parambfro, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambfro, paramInt, paramVarArgs));
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
  
  public void a(bfro parambfro)
  {
    if (parambfro != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambfro);
      this.jdField_b_of_type_JavaUtilList.remove(parambfro);
      return;
    }
    finally
    {
      parambfro = finally;
      throw parambfro;
    }
  }
  
  public void a(bfro parambfro, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambfro);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambfro);
    }
  }
  
  public void a(Class<? extends bfro> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bfro localbfro;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbfro = (bfro)localIterator.next();
        if ((paramClass != null) && (localbfro != null) && (paramClass.isAssignableFrom(localbfro.getClass()))) {
          a(localbfro, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbfro = (bfro)localIterator.next();
        if ((paramClass != null) && (localbfro != null) && (paramClass.isAssignableFrom(localbfro.getClass()))) {
          a(localbfro, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrn
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bjuj
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bjuk> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bjuk> jdField_b_of_type_JavaUtilList = new Vector();
  
  bjuj()
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
  
  private void a(bjuk parambjuk, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambjuk, paramInt, paramVarArgs));
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
  
  public void a(bjuk parambjuk)
  {
    if (parambjuk != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambjuk);
      this.jdField_b_of_type_JavaUtilList.remove(parambjuk);
      return;
    }
    finally
    {
      parambjuk = finally;
      throw parambjuk;
    }
  }
  
  public void a(bjuk parambjuk, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambjuk);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambjuk);
    }
  }
  
  public void a(Class<? extends bjuk> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bjuk localbjuk;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbjuk = (bjuk)localIterator.next();
        if ((paramClass != null) && (localbjuk != null) && (paramClass.isAssignableFrom(localbjuk.getClass()))) {
          a(localbjuk, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbjuk = (bjuk)localIterator.next();
        if ((paramClass != null) && (localbjuk != null) && (paramClass.isAssignableFrom(localbjuk.getClass()))) {
          a(localbjuk, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuj
 * JD-Core Version:    0.7.0.1
 */
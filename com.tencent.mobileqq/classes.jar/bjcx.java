import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class bjcx
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final List<bjcy> jdField_a_of_type_JavaUtilList = new Vector();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final List<bjcy> jdField_b_of_type_JavaUtilList = new Vector();
  
  bjcx()
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
  
  private void a(bjcy parambjcy, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, parambjcy, paramInt, paramVarArgs));
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
  
  public void a(bjcy parambjcy)
  {
    if (parambjcy != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambjcy);
      this.jdField_b_of_type_JavaUtilList.remove(parambjcy);
      return;
    }
    finally
    {
      parambjcy = finally;
      throw parambjcy;
    }
  }
  
  public void a(bjcy parambjcy, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(parambjcy);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(parambjcy);
    }
  }
  
  public void a(Class<? extends bjcy> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    bjcy localbjcy;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbjcy = (bjcy)localIterator.next();
        if ((paramClass != null) && (localbjcy != null) && (paramClass.isAssignableFrom(localbjcy.getClass()))) {
          a(localbjcy, this.jdField_a_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localbjcy = (bjcy)localIterator.next();
        if ((paramClass != null) && (localbjcy != null) && (paramClass.isAssignableFrom(localbjcy.getClass()))) {
          a(localbjcy, this.jdField_b_of_type_AndroidOsHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcx
 * JD-Core Version:    0.7.0.1
 */
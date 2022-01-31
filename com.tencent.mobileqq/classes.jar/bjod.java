import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjod
  extends bjof
{
  @Nullable
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(2, new bjoe(this));
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(paramRunnable);
  }
  
  public boolean a()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */
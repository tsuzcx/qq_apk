import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask.SerialExecutor.1;
import com.tencent.qqmini.sdk.core.utils.thread.internel.ArrayDeque;
import java.util.concurrent.Executor;

public class bemg
  implements Executor
{
  final ArrayDeque<Runnable> jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadInternelArrayDeque = new ArrayDeque();
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  public void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadInternelArrayDeque.poll();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        AsyncTask.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadInternelArrayDeque.offer(new AsyncTask.SerialExecutor.1(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemg
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class arrs
{
  private static arrs jdField_a_of_type_Arrs;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private arrs()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.corePoolsize = i;
      localThreadPoolParams.maxPooolSize = i;
      localThreadPoolParams.priority = 5;
      localThreadPoolParams.poolThreadName = "msgbackup_Tranport_Executor";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
    }
  }
  
  public static arrs a()
  {
    try
    {
      if (jdField_a_of_type_Arrs == null) {
        jdField_a_of_type_Arrs = new arrs();
      }
      arrs localarrs = jdField_a_of_type_Arrs;
      return localarrs;
    }
    finally {}
  }
  
  public void a()
  {
    arsc.a("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get(), new Object[0]);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
      arsc.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrs
 * JD-Core Version:    0.7.0.1
 */
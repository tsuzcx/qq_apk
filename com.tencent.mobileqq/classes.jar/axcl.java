import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class axcl
{
  private static axcl jdField_a_of_type_Axcl;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private axcl()
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
  
  public static axcl a()
  {
    try
    {
      if (jdField_a_of_type_Axcl == null) {
        jdField_a_of_type_Axcl = new axcl();
      }
      axcl localaxcl = jdField_a_of_type_Axcl;
      return localaxcl;
    }
    finally {}
  }
  
  public void a()
  {
    axcw.a("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get(), new Object[0]);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
      axcw.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcl
 * JD-Core Version:    0.7.0.1
 */
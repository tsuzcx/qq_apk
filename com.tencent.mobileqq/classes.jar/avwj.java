import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class avwj
{
  private static avwj jdField_a_of_type_Avwj;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private avwj()
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
  
  public static avwj a()
  {
    try
    {
      if (jdField_a_of_type_Avwj == null) {
        jdField_a_of_type_Avwj = new avwj();
      }
      avwj localavwj = jdField_a_of_type_Avwj;
      return localavwj;
    }
    finally {}
  }
  
  public void a()
  {
    avwu.a("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get(), new Object[0]);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
      avwu.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwj
 * JD-Core Version:    0.7.0.1
 */
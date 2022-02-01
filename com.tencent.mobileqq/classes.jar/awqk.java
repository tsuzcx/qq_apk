import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class awqk
{
  private static awqk jdField_a_of_type_Awqk;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  private awqk()
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
  
  public static awqk a()
  {
    try
    {
      if (jdField_a_of_type_Awqk == null) {
        jdField_a_of_type_Awqk = new awqk();
      }
      awqk localawqk = jdField_a_of_type_Awqk;
      return localawqk;
    }
    finally {}
  }
  
  public void a()
  {
    awqu.a("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get(), new Object[0]);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
      awqu.a("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqk
 * JD-Core Version:    0.7.0.1
 */
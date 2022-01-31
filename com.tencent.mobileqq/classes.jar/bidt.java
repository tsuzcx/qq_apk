import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class bidt
  extends RemoteCommand
{
  private static bidu jdField_a_of_type_Bidu;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public bidt()
  {
    super("weiyun.notify_state");
  }
  
  public void a(bidu parambidu)
  {
    jdField_a_of_type_Bidu = parambidu;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (i != jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (jdField_a_of_type_Bidu != null) {
        jdField_a_of_type_Bidu.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidt
 * JD-Core Version:    0.7.0.1
 */
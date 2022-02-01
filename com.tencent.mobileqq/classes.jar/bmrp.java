import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class bmrp
  extends RemoteCommand
{
  private static bmrq jdField_a_of_type_Bmrq;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public bmrp()
  {
    super("weiyun.notify_state");
  }
  
  public void a(bmrq parambmrq)
  {
    jdField_a_of_type_Bmrq = parambmrq;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if (i != jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (jdField_a_of_type_Bmrq != null) {
        jdField_a_of_type_Bmrq.a(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrp
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import dov.com.qq.im.capture.control.CaptureAsyncAutomator;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class bhgi
  implements ThreadFactory
{
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  private bhgi(CaptureAsyncAutomator paramCaptureAsyncAutomator) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "CaptureAsyncAutomator_" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    paramRunnable.setPriority(4);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhgi
 * JD-Core Version:    0.7.0.1
 */
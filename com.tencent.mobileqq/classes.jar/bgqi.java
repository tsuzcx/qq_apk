import com.tencent.qqmini.sdk.core.utils.thread.PriorityThreadFactory.1;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class bgqi
  implements ThreadFactory
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new PriorityThreadFactory.1(this, paramRunnable, this.jdField_a_of_type_JavaLangString + '-' + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqi
 * JD-Core Version:    0.7.0.1
 */
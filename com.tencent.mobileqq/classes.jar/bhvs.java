import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class bhvs
  implements ThreadFactory
{
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  bhvs(bhvr parambhvr) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement()) }));
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvs
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class bhhu
  implements ThreadFactory
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private final String jdField_a_of_type_JavaLangString;
  private final ThreadGroup jdField_a_of_type_JavaLangThreadGroup;
  private final AtomicInteger b = new AtomicInteger(1);
  
  bhhu(String paramString)
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.jdField_a_of_type_JavaLangThreadGroup = ((ThreadGroup)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "threadpool";
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject + "-" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() + "-thread-");
      return;
    }
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.jdField_a_of_type_JavaLangThreadGroup, paramRunnable, this.jdField_a_of_type_JavaLangString + this.b.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhu
 * JD-Core Version:    0.7.0.1
 */
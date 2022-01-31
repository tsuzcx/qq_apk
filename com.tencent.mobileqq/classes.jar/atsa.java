import com.tencent.mobileqq.lyric.common.TimerTaskManager.InternalTaskEntry.1;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import java.util.concurrent.ScheduledFuture;

public class atsa
{
  private long jdField_a_of_type_Long = -9223372036854775808L;
  private TimerTaskManager.TimerTaskRunnable jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TimerTaskManager.InternalTaskEntry.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ScheduledFuture<?> jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  
  public static atsa a(TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    atsa localatsa = new atsa();
    TimerTaskManager.TimerTaskRunnable.a(paramTimerTaskRunnable, true);
    localatsa.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = paramTimerTaskRunnable;
    return localatsa;
  }
  
  public String toString()
  {
    boolean bool2 = false;
    long l = this.jdField_a_of_type_Long;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable != null)
    {
      bool1 = bool2;
      if (TimerTaskManager.TimerTaskRunnable.a(this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable)) {
        bool1 = true;
      }
    }
    return String.format("Period = %d; IsValid = %b;", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsa
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;

public class avjy
{
  private static final avki<Handler, Void> a = new avjz();
  private static avki<TimerTaskManager, Void> b = new avka();
  
  public static Handler a()
  {
    return (Handler)a.get(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.get(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjy
 * JD-Core Version:    0.7.0.1
 */
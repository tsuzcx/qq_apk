import android.os.Handler;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;

public class awqd
{
  private static final awqn<Handler, Void> a = new awqe();
  private static awqn<TimerTaskManager, Void> b = new awqf();
  
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
 * Qualified Name:     awqd
 * JD-Core Version:    0.7.0.1
 */
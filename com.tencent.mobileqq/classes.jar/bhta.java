import android.os.Handler;
import android.os.Looper;

public class bhta
{
  private static Handler a;
  
  public static void a(Runnable paramRunnable)
  {
    try
    {
      if (a == null) {
        a = new Handler(Looper.getMainLooper());
      }
      a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (a == null) {
        a = new Handler(Looper.getMainLooper());
      }
      a.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhta
 * JD-Core Version:    0.7.0.1
 */
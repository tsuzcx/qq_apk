import android.os.Handler;
import android.os.Looper;

public class bgkk
{
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkk
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;

public class beki
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beki
 * JD-Core Version:    0.7.0.1
 */
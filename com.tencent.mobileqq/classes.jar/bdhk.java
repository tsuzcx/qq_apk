import android.os.Looper;

public final class bdhk
{
  public static final bdhl a;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      a = new bdhl(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdhk
 * JD-Core Version:    0.7.0.1
 */
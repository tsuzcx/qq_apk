import android.os.Looper;

public final class bglu
{
  public static final bglv a;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      a = new bglv(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglu
 * JD-Core Version:    0.7.0.1
 */
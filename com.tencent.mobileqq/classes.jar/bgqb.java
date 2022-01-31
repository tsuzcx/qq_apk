import android.os.Looper;

public final class bgqb
{
  public static final bgqc a;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      a = new bgqc(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqb
 * JD-Core Version:    0.7.0.1
 */
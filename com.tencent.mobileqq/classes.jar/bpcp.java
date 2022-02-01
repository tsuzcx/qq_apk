import android.os.Handler;
import android.os.Looper;

final class bpcp
  extends bpcr<Handler, Void>
{
  protected Handler a(Void paramVoid)
  {
    return new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcp
 * JD-Core Version:    0.7.0.1
 */
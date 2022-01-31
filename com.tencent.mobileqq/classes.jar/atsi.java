import android.os.Handler;
import android.os.Looper;

final class atsi
  extends atsr<Handler, Void>
{
  protected Handler a(Void paramVoid)
  {
    return new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsi
 * JD-Core Version:    0.7.0.1
 */
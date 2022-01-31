import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class attj
  extends Handler
{
  java.lang.ref.WeakReference<atsz> a;
  
  public attj(atsz paramatsz)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramatsz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    atsz localatsz;
    do
    {
      return;
      localatsz = (atsz)this.a.get();
    } while (localatsz == null);
    localatsz.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attj
 * JD-Core Version:    0.7.0.1
 */
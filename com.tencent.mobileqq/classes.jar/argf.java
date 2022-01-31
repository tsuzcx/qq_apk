import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class argf
  extends Handler
{
  java.lang.ref.WeakReference<arfv> a;
  
  public argf(arfv paramarfv)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramarfv);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    arfv localarfv;
    do
    {
      return;
      localarfv = (arfv)this.a.get();
    } while (localarfv == null);
    localarfv.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     argf
 * JD-Core Version:    0.7.0.1
 */
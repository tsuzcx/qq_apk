import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class awrf
  extends Handler
{
  java.lang.ref.WeakReference<awqv> a;
  
  public awrf(awqv paramawqv)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramawqv);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    awqv localawqv;
    do
    {
      return;
      localawqv = (awqv)this.a.get();
    } while (localawqv == null);
    localawqv.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrf
 * JD-Core Version:    0.7.0.1
 */
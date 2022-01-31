import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class asch
  extends Handler
{
  java.lang.ref.WeakReference<asbx> a;
  
  public asch(asbx paramasbx)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramasbx);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    asbx localasbx;
    do
    {
      return;
      localasbx = (asbx)this.a.get();
    } while (localasbx == null);
    localasbx.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asch
 * JD-Core Version:    0.7.0.1
 */
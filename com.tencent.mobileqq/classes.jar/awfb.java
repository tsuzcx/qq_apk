import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class awfb
  extends Handler
{
  java.lang.ref.WeakReference<awer> a;
  
  public awfb(awer paramawer)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramawer);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    awer localawer;
    do
    {
      return;
      localawer = (awer)this.a.get();
    } while (localawer == null);
    localawer.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfb
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bmyf
  extends Handler
{
  private WeakReference<bmye> a;
  
  public bmyf(WeakReference<bmye> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bmye.a((bmye)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyf
 * JD-Core Version:    0.7.0.1
 */
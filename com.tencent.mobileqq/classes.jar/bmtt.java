import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bmtt
  extends Handler
{
  private WeakReference<bmts> a;
  
  public bmtt(WeakReference<bmts> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bmts.a((bmts)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtt
 * JD-Core Version:    0.7.0.1
 */
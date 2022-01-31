import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bkhs
  extends Handler
{
  private WeakReference<bkhr> a;
  
  public bkhs(WeakReference<bkhr> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bkhr.a((bkhr)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhs
 * JD-Core Version:    0.7.0.1
 */
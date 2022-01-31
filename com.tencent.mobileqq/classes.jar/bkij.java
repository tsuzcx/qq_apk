import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bkij
  extends Handler
{
  private WeakReference<bkii> a;
  
  public bkij(WeakReference<bkii> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bkii.a((bkii)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkij
 * JD-Core Version:    0.7.0.1
 */
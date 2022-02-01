import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bqrg
  extends Handler
{
  private WeakReference<bqrf> a;
  
  public bqrg(WeakReference<bqrf> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bqrf.a((bqrf)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqrg
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bppl
  extends Handler
{
  private WeakReference<bppk> a;
  
  public bppl(WeakReference<bppk> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bppk.a((bppk)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppl
 * JD-Core Version:    0.7.0.1
 */
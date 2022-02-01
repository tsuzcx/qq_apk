import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bpdc
  extends Handler
{
  private WeakReference<bpdb> a;
  
  public bpdc(WeakReference<bpdb> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bpdb.a((bpdb)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdc
 * JD-Core Version:    0.7.0.1
 */
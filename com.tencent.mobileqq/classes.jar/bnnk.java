import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class bnnk
  extends Handler
{
  private WeakReference<bnnj> a;
  
  public bnnk(WeakReference<bnnj> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      bnnj.a((bnnj)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnk
 * JD-Core Version:    0.7.0.1
 */
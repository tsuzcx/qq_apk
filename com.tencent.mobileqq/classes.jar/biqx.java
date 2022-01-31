import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class biqx
  extends Handler
{
  private WeakReference<biqw> a;
  
  public biqx(WeakReference<biqw> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.get() != null) {
      biqw.a((biqw)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqx
 * JD-Core Version:    0.7.0.1
 */
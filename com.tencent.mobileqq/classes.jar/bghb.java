import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class bghb
  implements bgil
{
  private WeakReference<Handler> a;
  
  public bghb(Handler paramHandler)
  {
    this.a = new WeakReference(paramHandler);
  }
  
  public void a(int paramInt, String paramString)
  {
    Handler localHandler = (Handler)this.a.get();
    if (localHandler != null) {
      localHandler.obtainMessage(1001, paramInt, 0, paramString).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghb
 * JD-Core Version:    0.7.0.1
 */
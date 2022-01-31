import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class bimx
  implements bioh
{
  private WeakReference<Handler> a;
  
  public bimx(Handler paramHandler)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimx
 * JD-Core Version:    0.7.0.1
 */
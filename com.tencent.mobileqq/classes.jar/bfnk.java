import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bfnk
  extends MqqHandler
{
  private WeakReference<Handler.Callback> a;
  
  public bfnk(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public bfnk(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public bfnk(Looper paramLooper, Handler.Callback paramCallback, boolean paramBoolean)
  {
    super(paramLooper, null, paramBoolean);
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
  
  public String toString()
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    return super.toString() + " " + localCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfnk
 * JD-Core Version:    0.7.0.1
 */
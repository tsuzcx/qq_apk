import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bhow
  extends Handler
{
  private WeakReference<Handler.Callback> a;
  
  public bhow(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public bhow(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("WeakReferenceHandler", 2, "handleMessage cb is null! handler = " + this);
  }
  
  public String toString()
  {
    Object localObject = (Handler.Callback)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder().append("WH");
    if (localObject != null) {}
    for (localObject = localObject.toString();; localObject = "None callback") {
      return (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhow
 * JD-Core Version:    0.7.0.1
 */
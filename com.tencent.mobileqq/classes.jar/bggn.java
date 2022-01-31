import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class bggn<T>
  extends Handler
{
  private WeakReference<T> a;
  
  public bggn(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, Message paramMessage);
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = this.a.get();
    if (localObject != null) {
      a(localObject, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggn
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class aufw
  extends Handler
{
  private WeakReference<aufj> a;
  
  public aufw(aufj paramaufj)
  {
    this.a = new WeakReference(paramaufj);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aufj localaufj = (aufj)this.a.get();
    if (localaufj == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      aufj.a(localaufj, (aufy)paramMessage.obj);
      return;
    }
    aufj.a(localaufj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufw
 * JD-Core Version:    0.7.0.1
 */
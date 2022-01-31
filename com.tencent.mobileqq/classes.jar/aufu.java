import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class aufu
  extends Handler
{
  private WeakReference<aufh> a;
  
  public aufu(aufh paramaufh)
  {
    this.a = new WeakReference(paramaufh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aufh localaufh = (aufh)this.a.get();
    if (localaufh == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      aufh.a(localaufh, (aufw)paramMessage.obj);
      return;
    }
    aufh.a(localaufh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufu
 * JD-Core Version:    0.7.0.1
 */
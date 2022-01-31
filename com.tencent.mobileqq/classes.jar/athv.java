import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class athv
  extends Handler
{
  private WeakReference<athi> a;
  
  public athv(athi paramathi)
  {
    this.a = new WeakReference(paramathi);
  }
  
  public void handleMessage(Message paramMessage)
  {
    athi localathi = (athi)this.a.get();
    if (localathi == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      athi.a(localathi, (athx)paramMessage.obj);
      return;
    }
    athi.a(localathi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     athv
 * JD-Core Version:    0.7.0.1
 */
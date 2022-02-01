import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class axrc
  extends Handler
{
  private WeakReference<axqp> a;
  
  public axrc(axqp paramaxqp)
  {
    this.a = new WeakReference(paramaxqp);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axqp localaxqp = (axqp)this.a.get();
    if (localaxqp == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      axqp.a(localaxqp, (axre)paramMessage.obj);
      return;
    }
    axqp.a(localaxqp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrc
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class avxa
  extends Handler
{
  private WeakReference<avwn> a;
  
  public avxa(avwn paramavwn)
  {
    this.a = new WeakReference(paramavwn);
  }
  
  public void handleMessage(Message paramMessage)
  {
    avwn localavwn = (avwn)this.a.get();
    if (localavwn == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      avwn.a(localavwn, (avxc)paramMessage.obj);
      return;
    }
    avwn.a(localavwn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxa
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class avla
  extends Handler
{
  java.lang.ref.WeakReference<avkq> a;
  
  public avla(avkq paramavkq)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramavkq);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    avkq localavkq;
    do
    {
      return;
      localavkq = (avkq)this.a.get();
    } while (localavkq == null);
    localavkq.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avla
 * JD-Core Version:    0.7.0.1
 */
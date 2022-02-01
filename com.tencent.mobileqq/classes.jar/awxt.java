import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class awxt
  extends Handler
{
  java.lang.ref.WeakReference<awxj> a;
  
  public awxt(awxj paramawxj)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramawxj);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    awxj localawxj;
    do
    {
      return;
      localawxj = (awxj)this.a.get();
    } while (localawxj == null);
    localawxj.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxt
 * JD-Core Version:    0.7.0.1
 */
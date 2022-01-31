import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class atxs
  extends Handler
{
  java.lang.ref.WeakReference<atxi> a;
  
  public atxs(atxi paramatxi)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramatxi);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    atxi localatxi;
    do
    {
      return;
      localatxi = (atxi)this.a.get();
    } while (localatxi == null);
    localatxi.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxs
 * JD-Core Version:    0.7.0.1
 */
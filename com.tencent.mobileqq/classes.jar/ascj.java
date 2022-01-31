import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ascj
  extends Handler
{
  java.lang.ref.WeakReference<asbz> a;
  
  public ascj(asbz paramasbz)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramasbz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    asbz localasbz;
    do
    {
      return;
      localasbz = (asbz)this.a.get();
    } while (localasbz == null);
    localasbz.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascj
 * JD-Core Version:    0.7.0.1
 */
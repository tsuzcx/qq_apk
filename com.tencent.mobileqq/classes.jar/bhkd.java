import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bhkd
  extends Handler
{
  final WeakReference<bhkb> a;
  
  public bhkd(bhkb parambhkb)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambhkb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bhkb localbhkb = (bhkb)this.a.get();
    if (localbhkb == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbhkb.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkd
 * JD-Core Version:    0.7.0.1
 */
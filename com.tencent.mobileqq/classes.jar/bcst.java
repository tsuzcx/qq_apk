import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bcst
  extends Handler
{
  final WeakReference<bcsr> a;
  
  public bcst(bcsr parambcsr)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambcsr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bcsr localbcsr = (bcsr)this.a.get();
    if (localbcsr == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbcsr.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcst
 * JD-Core Version:    0.7.0.1
 */
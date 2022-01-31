import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bcse
  extends Handler
{
  final WeakReference<bcsc> a;
  
  public bcse(bcsc parambcsc)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambcsc);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bcsc localbcsc = (bcsc)this.a.get();
    if (localbcsc == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbcsc.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcse
 * JD-Core Version:    0.7.0.1
 */
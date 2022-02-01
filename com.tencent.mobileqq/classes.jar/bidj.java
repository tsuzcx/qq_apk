import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bidj
  extends Handler
{
  final WeakReference<bidh> a;
  
  public bidj(bidh parambidh)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambidh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bidh localbidh = (bidh)this.a.get();
    if (localbidh == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbidh.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidj
 * JD-Core Version:    0.7.0.1
 */
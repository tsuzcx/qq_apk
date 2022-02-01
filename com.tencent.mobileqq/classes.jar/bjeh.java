import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bjeh
  extends Handler
{
  final WeakReference<bjef> a;
  
  public bjeh(bjef parambjef)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambjef);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bjef localbjef = (bjef)this.a.get();
    if (localbjef == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbjef.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeh
 * JD-Core Version:    0.7.0.1
 */
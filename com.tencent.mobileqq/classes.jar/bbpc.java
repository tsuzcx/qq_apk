import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bbpc
  extends Handler
{
  final WeakReference<bbpa> a;
  
  public bbpc(bbpa parambbpa)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambbpa);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbpa localbbpa = (bbpa)this.a.get();
    if (localbbpa == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbbpa.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpc
 * JD-Core Version:    0.7.0.1
 */
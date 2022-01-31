import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class bewl
  extends Handler
{
  final WeakReference<bewj> a;
  
  public bewl(bewj parambewj)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambewj);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bewj localbewj = (bewj)this.a.get();
    if (localbewj == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbewj.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewl
 * JD-Core Version:    0.7.0.1
 */
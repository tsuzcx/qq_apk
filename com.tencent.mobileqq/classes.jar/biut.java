import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class biut
  extends Handler
{
  final WeakReference<biur> a;
  
  public biut(biur parambiur)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambiur);
  }
  
  public void handleMessage(Message paramMessage)
  {
    biur localbiur = (biur)this.a.get();
    if (localbiur == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbiur.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biut
 * JD-Core Version:    0.7.0.1
 */
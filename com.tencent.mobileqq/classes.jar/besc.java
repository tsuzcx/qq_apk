import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.util.WeakReference;

class besc
  extends Handler
{
  final WeakReference<besa> a;
  
  public besc(besa parambesa)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(parambesa);
  }
  
  public void handleMessage(Message paramMessage)
  {
    besa localbesa = (besa)this.a.get();
    if (localbesa == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localbesa.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besc
 * JD-Core Version:    0.7.0.1
 */
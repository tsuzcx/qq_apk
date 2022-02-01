import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class azdu
  extends Handler
{
  private WeakReference<azdh> a;
  
  public azdu(azdh paramazdh)
  {
    this.a = new WeakReference(paramazdh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    azdh localazdh = (azdh)this.a.get();
    if (localazdh == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      azdh.a(localazdh, (azdw)paramMessage.obj);
      return;
    }
    azdh.a(localazdh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdu
 * JD-Core Version:    0.7.0.1
 */
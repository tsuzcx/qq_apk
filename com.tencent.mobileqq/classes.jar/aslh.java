import android.os.Handler;
import android.os.Message;

class aslh
  extends Handler
{
  aslh(aslg paramaslg) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 5: 
    default: 
      return;
    case 0: 
      this.a.a();
      return;
    case 1: 
      aslg.a(this.a);
      return;
    case 6: 
      aslg.b(this.a);
      return;
    case 2: 
      aslg.c(this.a);
      return;
    case 3: 
      aslg.d(this.a);
      return;
    case 4: 
      aslg.e(this.a);
      return;
    }
    aslg.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslh
 * JD-Core Version:    0.7.0.1
 */
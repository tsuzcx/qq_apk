import android.os.Handler;
import android.os.Message;

class asgy
  extends Handler
{
  asgy(asgx paramasgx) {}
  
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
      asgx.a(this.a);
      return;
    case 6: 
      asgx.b(this.a);
      return;
    case 2: 
      asgx.c(this.a);
      return;
    case 3: 
      asgx.d(this.a);
      return;
    case 4: 
      asgx.e(this.a);
      return;
    }
    asgx.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgy
 * JD-Core Version:    0.7.0.1
 */
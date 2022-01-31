import android.os.Handler;
import android.os.Message;

class aqrg
  extends Handler
{
  aqrg(aqrf paramaqrf) {}
  
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
      aqrf.a(this.a);
      return;
    case 6: 
      aqrf.b(this.a);
      return;
    case 2: 
      aqrf.c(this.a);
      return;
    case 3: 
      aqrf.d(this.a);
      return;
    case 4: 
      aqrf.e(this.a);
      return;
    }
    aqrf.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrg
 * JD-Core Version:    0.7.0.1
 */
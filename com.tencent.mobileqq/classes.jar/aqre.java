import android.os.Handler;
import android.os.Message;

class aqre
  extends Handler
{
  aqre(aqrd paramaqrd) {}
  
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
      aqrd.a(this.a);
      return;
    case 6: 
      aqrd.b(this.a);
      return;
    case 2: 
      aqrd.c(this.a);
      return;
    case 3: 
      aqrd.d(this.a);
      return;
    case 4: 
      aqrd.e(this.a);
      return;
    }
    aqrd.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqre
 * JD-Core Version:    0.7.0.1
 */
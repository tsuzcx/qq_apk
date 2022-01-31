import android.os.Handler;
import android.os.Message;

class apxc
  extends Handler
{
  apxc(apxb paramapxb) {}
  
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
      apxb.a(this.a);
      return;
    case 6: 
      apxb.b(this.a);
      return;
    case 2: 
      apxb.c(this.a);
      return;
    case 3: 
      apxb.d(this.a);
      return;
    case 4: 
      apxb.e(this.a);
      return;
    }
    apxb.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apxc
 * JD-Core Version:    0.7.0.1
 */
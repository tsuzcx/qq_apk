import android.os.Handler;
import android.os.Message;

class apwv
  extends Handler
{
  apwv(apwu paramapwu) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 3: 
    case 5: 
    default: 
      return;
    case 0: 
      this.a.a();
      return;
    case 1: 
      apwu.a(this.a);
      return;
    case 6: 
      apwu.b(this.a);
      return;
    case 2: 
      apwu.c(this.a);
      return;
    case 4: 
      apwu.d(this.a);
      return;
    }
    apwu.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apwv
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Message;

class asgr
  extends Handler
{
  asgr(asgq paramasgq) {}
  
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
      asgq.a(this.a);
      return;
    case 6: 
      asgq.b(this.a);
      return;
    case 2: 
      asgq.c(this.a);
      return;
    case 4: 
      asgq.d(this.a);
      return;
    }
    asgq.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgr
 * JD-Core Version:    0.7.0.1
 */
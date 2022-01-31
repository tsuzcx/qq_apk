import android.os.Handler;
import android.os.Message;

class asla
  extends Handler
{
  asla(askz paramaskz) {}
  
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
      askz.a(this.a);
      return;
    case 6: 
      askz.b(this.a);
      return;
    case 2: 
      askz.c(this.a);
      return;
    case 4: 
      askz.d(this.a);
      return;
    }
    askz.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asla
 * JD-Core Version:    0.7.0.1
 */
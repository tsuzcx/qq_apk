import android.os.Handler;
import android.os.Message;

class aqqz
  extends Handler
{
  aqqz(aqqy paramaqqy) {}
  
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
      aqqy.a(this.a);
      return;
    case 6: 
      aqqy.b(this.a);
      return;
    case 2: 
      aqqy.c(this.a);
      return;
    case 4: 
      aqqy.d(this.a);
      return;
    }
    aqqy.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqz
 * JD-Core Version:    0.7.0.1
 */
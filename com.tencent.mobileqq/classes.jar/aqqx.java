import android.os.Handler;
import android.os.Message;

class aqqx
  extends Handler
{
  aqqx(aqqw paramaqqw) {}
  
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
      aqqw.a(this.a);
      return;
    case 6: 
      aqqw.b(this.a);
      return;
    case 2: 
      aqqw.c(this.a);
      return;
    case 4: 
      aqqw.d(this.a);
      return;
    }
    aqqw.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */
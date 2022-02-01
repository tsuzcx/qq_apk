import android.os.Handler;
import android.os.Message;

class bnng
  extends Handler
{
  private bnng(bnne parambnne) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1004: 
    case 1009: 
      bnne.a(this.a);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnng
 * JD-Core Version:    0.7.0.1
 */
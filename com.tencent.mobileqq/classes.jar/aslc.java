import android.os.Handler.Callback;
import android.os.Message;

class aslc
  implements Handler.Callback
{
  aslc(aslb paramaslb) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    aslb.a(this.a, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aslc
 * JD-Core Version:    0.7.0.1
 */
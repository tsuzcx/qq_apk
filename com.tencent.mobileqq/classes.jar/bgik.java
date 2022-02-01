import android.os.Handler.Callback;
import android.os.Message;

class bgik
  implements Handler.Callback
{
  bgik(bgih parambgih) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bgih.a().a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgik
 * JD-Core Version:    0.7.0.1
 */
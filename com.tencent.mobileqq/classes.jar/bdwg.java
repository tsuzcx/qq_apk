import android.os.Handler.Callback;
import android.os.Message;

class bdwg
  implements Handler.Callback
{
  bdwg(bdwf parambdwf) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bdwh.a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwg
 * JD-Core Version:    0.7.0.1
 */
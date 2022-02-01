import android.os.Handler.Callback;
import android.os.Message;

class bhrf
  implements Handler.Callback
{
  bhrf(bhrc parambhrc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bhrc.a().a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrf
 * JD-Core Version:    0.7.0.1
 */
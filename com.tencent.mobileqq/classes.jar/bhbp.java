import android.os.Handler.Callback;
import android.os.Message;

class bhbp
  implements Handler.Callback
{
  bhbp(bhbn parambhbn) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bhbn.a().a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbp
 * JD-Core Version:    0.7.0.1
 */
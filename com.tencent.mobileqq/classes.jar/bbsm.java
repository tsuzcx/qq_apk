import android.os.Handler.Callback;
import android.os.Message;

class bbsm
  implements Handler.Callback
{
  bbsm(bbsl parambbsl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bbsn.a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsm
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler.Callback;
import android.os.Message;

class bbta
  implements Handler.Callback
{
  bbta(bbsz parambbsz) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bbtb.a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbta
 * JD-Core Version:    0.7.0.1
 */
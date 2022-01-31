import android.os.Handler.Callback;
import android.os.Message;

class bdrx
  implements Handler.Callback
{
  bdrx(bdrw parambdrw) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      bdry.a(paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrx
 * JD-Core Version:    0.7.0.1
 */
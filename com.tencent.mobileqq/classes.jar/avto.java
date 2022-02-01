import android.os.Handler.Callback;
import android.os.Message;

class avto
  implements Handler.Callback
{
  avto(avtn paramavtn) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    avtn.a(this.a, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avto
 * JD-Core Version:    0.7.0.1
 */
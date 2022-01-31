import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class ansi
  implements Handler.Callback
{
  ansi(ansh paramansh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      bcpw.a(ansh.a(this.a), 2131692829, 0).b(2131298865);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    bcpw.a(ansh.a(this.a), 1, 2131689687, 0).b(2131298865);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansi
 * JD-Core Version:    0.7.0.1
 */
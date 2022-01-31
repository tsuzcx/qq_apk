import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class anbx
  implements Handler.Callback
{
  anbx(anbw paramanbw) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      bbmy.a(anbw.a(this.a), 2131627191, 0).b(2131167766);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    bbmy.a(anbw.a(this.a), 1, 2131624147, 0).b(2131167766);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbx
 * JD-Core Version:    0.7.0.1
 */
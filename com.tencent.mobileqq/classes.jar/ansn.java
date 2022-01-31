import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class ansn
  implements Handler.Callback
{
  ansn(ansm paramansm) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      bcql.a(ansm.a(this.a), 2131692830, 0).b(2131298865);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    bcql.a(ansm.a(this.a), 1, 2131689687, 0).b(2131298865);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansn
 * JD-Core Version:    0.7.0.1
 */
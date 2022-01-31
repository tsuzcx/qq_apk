import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.MessageForFuDai;

public class aqln
  implements adih, Handler.Callback
{
  private BaseChatPie a;
  
  public aqln(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
    case 13: 
      aqlo.e();
      return;
    }
    aqlo.f();
  }
  
  void a(MessageForFuDai paramMessageForFuDai) {}
  
  public int[] a()
  {
    return new int[] { 2, 11, 12, 13, 14 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqln
 * JD-Core Version:    0.7.0.1
 */
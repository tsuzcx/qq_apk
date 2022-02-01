import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.MessageForFuDai;

public class auqf
  implements agma, Handler.Callback
{
  private BaseChatPie a;
  
  public auqf(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 14: 
    case 15: 
      auqg.e();
      return;
    }
    auqg.f();
  }
  
  void a(MessageForFuDai paramMessageForFuDai) {}
  
  public int[] a()
  {
    return new int[] { 3, 13, 14, 15, 16 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqf
 * JD-Core Version:    0.7.0.1
 */
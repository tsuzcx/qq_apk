import android.content.Intent;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;

public class aosg
  extends aosi
{
  protected aosg(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    String str2 = a().getStringExtra("subAccountLatestNick");
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = paramMessage.senderuin;
    }
    str2 = a() + "-" + str1 + ":" + c();
    this.a.b(str2);
    String str1 = str1 + ":" + c();
    this.a.d(str1);
    this.a.a(null);
    b(paramMessage);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosg
 * JD-Core Version:    0.7.0.1
 */
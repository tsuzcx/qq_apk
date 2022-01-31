import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class bbku
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      return true;
      bcpw.a(localQQAppInterface.getApplication(), ajyc.a(2131716047), 0).a();
      continue;
      bcpw.a(localQQAppInterface.getApplication(), ajyc.a(2131716046), 0).a();
      continue;
      bcpw.a(localQQAppInterface.getApplication(), ajyc.a(2131716045), 0).a();
      continue;
      bcpw.a(localQQAppInterface.getApplication(), ajyc.a(2131716048), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbku
 * JD-Core Version:    0.7.0.1
 */
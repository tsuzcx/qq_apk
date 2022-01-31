import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class bajn
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
      bbmy.a(localQQAppInterface.getApplication(), ajjy.a(2131650256), 0).a();
      continue;
      bbmy.a(localQQAppInterface.getApplication(), ajjy.a(2131650255), 0).a();
      continue;
      bbmy.a(localQQAppInterface.getApplication(), ajjy.a(2131650254), 0).a();
      continue;
      bbmy.a(localQQAppInterface.getApplication(), ajjy.a(2131650257), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajn
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class bbli
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
      bcql.a(localQQAppInterface.getApplication(), ajya.a(2131716058), 0).a();
      continue;
      bcql.a(localQQAppInterface.getApplication(), ajya.a(2131716057), 0).a();
      continue;
      bcql.a(localQQAppInterface.getApplication(), ajya.a(2131716056), 0).a();
      continue;
      bcql.a(localQQAppInterface.getApplication(), ajya.a(2131716059), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbli
 * JD-Core Version:    0.7.0.1
 */
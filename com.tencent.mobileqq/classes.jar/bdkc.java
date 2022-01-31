import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class bdkc
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
      QQToast.a(localQQAppInterface.getApplication(), alpo.a(2131716430), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alpo.a(2131716429), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alpo.a(2131716428), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alpo.a(2131716431), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkc
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class bdol
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
      QQToast.a(localQQAppInterface.getApplication(), alud.a(2131716442), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alud.a(2131716441), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alud.a(2131716440), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), alud.a(2131716443), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdol
 * JD-Core Version:    0.7.0.1
 */
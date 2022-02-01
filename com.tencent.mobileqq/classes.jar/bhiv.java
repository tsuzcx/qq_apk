import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class bhiv
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
      QQToast.a(localQQAppInterface.getApplication(), anvx.a(2131715410), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anvx.a(2131715409), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anvx.a(2131715408), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anvx.a(2131715411), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhiv
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class bgad
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
      QQToast.a(localQQAppInterface.getApplication(), amtj.a(2131715062), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), amtj.a(2131715061), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), amtj.a(2131715060), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), amtj.a(2131715063), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgad
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class bgtk
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
      QQToast.a(localQQAppInterface.getApplication(), anni.a(2131714719), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anni.a(2131714718), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anni.a(2131714717), 0).a();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), anni.a(2131714720), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtk
 * JD-Core Version:    0.7.0.1
 */
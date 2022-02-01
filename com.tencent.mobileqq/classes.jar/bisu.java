import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast.ProtectedToast;

public class bisu
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public bisu(QQToast.ProtectedToast paramProtectedToast, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.handleMessage(paramMessage);
      return true;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bisu
 * JD-Core Version:    0.7.0.1
 */
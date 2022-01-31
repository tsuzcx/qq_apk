import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class awzk
  extends Handler
{
  awzk(awzj paramawzj) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
    {
      awzj.a = false;
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzk
 * JD-Core Version:    0.7.0.1
 */
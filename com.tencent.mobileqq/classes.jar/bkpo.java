import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bkpo
  implements Handler.Callback
{
  bkpo(bkpn parambkpn) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + paramMessage.what);
    }
    bkpn.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpo
 * JD-Core Version:    0.7.0.1
 */
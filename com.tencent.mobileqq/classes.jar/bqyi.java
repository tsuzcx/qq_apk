import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bqyi
  implements Handler.Callback
{
  bqyi(bqyh parambqyh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + paramMessage.what);
    }
    bqyh.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyi
 * JD-Core Version:    0.7.0.1
 */
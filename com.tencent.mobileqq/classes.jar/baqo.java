import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class baqo
  implements Handler.Callback
{
  baqo(baqn parambaqn) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      QLog.i("GLDrawable", 1, paramMessage.obj.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqo
 * JD-Core Version:    0.7.0.1
 */
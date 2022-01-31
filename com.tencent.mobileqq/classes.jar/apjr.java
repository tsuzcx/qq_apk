import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class apjr
  extends Handler
{
  apjr(apjp paramapjp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (apjp.c(this.a));
    QLog.e("VoiceInputHelper", 1, "checkPermission uncertain");
    this.a.onGetError(1830002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjr
 * JD-Core Version:    0.7.0.1
 */
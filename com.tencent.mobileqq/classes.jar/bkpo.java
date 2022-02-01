import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.RspBody;

class bkpo
  extends Handler
{
  bkpo(bkpn parambkpn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = paramMessage.what;
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QfavFileForwardManager", 2, "receive passwdredbags from group or disgroup, isSuccess = " + bool);
      }
      if (bool) {
        break;
      }
      return;
      bool = false;
    }
    paramMessage = (oidb_cmd0xd68.RspBody)paramMessage.obj;
    switch (i)
    {
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpo
 * JD-Core Version:    0.7.0.1
 */
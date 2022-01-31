import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bjlo
  extends Handler
{
  bjlo(bjln parambjln, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "handleMessage, retryInstallNum=" + bjln.a());
    }
    if (paramMessage.what == 1) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      bjln.a(this.a).a(paramMessage, this.a, 2);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QZonePluginPreInstaller", 1, paramMessage, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlo
 * JD-Core Version:    0.7.0.1
 */
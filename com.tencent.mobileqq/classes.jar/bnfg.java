import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class bnfg
  extends Handler
{
  bnfg(bnff parambnff, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "handleMessage, retryInstallNum=" + bnff.a());
    }
    if (paramMessage.what == 1) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      bnff.a(this.a).a(paramMessage, this.a, 2);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QZonePluginPreInstaller", 1, paramMessage, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfg
 * JD-Core Version:    0.7.0.1
 */
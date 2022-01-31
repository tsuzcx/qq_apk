import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneStartupMonitor;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZoneExceptionReport;
import cooperation.qzone.util.exception.QZoneStartupFailException;

public class amzq
  extends Handler
{
  public amzq(QZoneStartupMonitor paramQZoneStartupMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 1;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      break;
    }
    do
    {
      return;
    } while (QZoneStartupMonitor.a(this.a));
    if (QzonePluginProxyActivity.a())
    {
      QLog.i("QZoneStartupMonitor", 1, "超时，但是qzone 进程存在");
      return;
    }
    QLog.e("QZoneStartupMonitor", 1, "启动超时认为启动失败，校验odex，并上报");
    paramMessage = QZoneStartupMonitor.a(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
    int i;
    if (paramMessage != null)
    {
      i = ((Integer)paramMessage.first).intValue();
      paramMessage = (Throwable)paramMessage.second;
    }
    for (;;)
    {
      int k = LocalMultiProcConfig.getInt("key_recovery_count", 0);
      QZoneStartupMonitor.a(this.a, i, QZoneStartupMonitor.a(this.a), k);
      StringBuilder localStringBuilder = new StringBuilder("qzone进程启动失败,elf valid errorcode: ").append(i).append(",recoveryCount:").append(k);
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "exception_report_rdm", 0) == 1) {}
      for (;;)
      {
        if (j != 0) {
          QZoneExceptionReport.a(new QZoneStartupFailException(paramMessage), localStringBuilder.toString());
        }
        if (i == 0) {
          break;
        }
        ThreadManager.postImmediately(new amzr(this, k), null, false);
        return;
        j = 0;
      }
      paramMessage = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzq
 * JD-Core Version:    0.7.0.1
 */
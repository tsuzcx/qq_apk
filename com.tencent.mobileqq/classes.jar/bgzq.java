import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.CaughtQZonePluginException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneStartupMonitor.2.1;
import cooperation.qzone.QzonePluginProxyActivity;

public class bgzq
  extends Handler
{
  bgzq(bgzo parambgzo, Looper paramLooper)
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
    } while (bgzo.a(this.a));
    if (QzonePluginProxyActivity.a())
    {
      QLog.i("QZoneStartupMonitor", 1, "超时，但是qzone 进程存在");
      return;
    }
    QLog.e("QZoneStartupMonitor", 1, "启动超时认为启动失败，校验odex，并上报");
    paramMessage = bgzo.a(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
    int i;
    if (paramMessage != null)
    {
      i = ((Integer)paramMessage.first).intValue();
      paramMessage = (Throwable)paramMessage.second;
    }
    for (;;)
    {
      int k = LocalMultiProcConfig.getInt("key_recovery_count", 0);
      bgzo.a(this.a, i, bgzo.a(this.a), k);
      StringBuilder localStringBuilder = new StringBuilder("qzone进程启动失败,elf valid errorcode: ").append(i).append(",recoveryCount:").append(k);
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "exception_report_rdm", 0) == 1) {}
      for (;;)
      {
        if (j != 0) {
          bhph.a(new CaughtQZonePluginException("start failed. " + paramMessage.getMessage()), localStringBuilder.toString());
        }
        if (i == 0) {
          break;
        }
        ThreadManager.postImmediately(new QZoneStartupMonitor.2.1(this, k), null, false);
        return;
        j = 0;
      }
      paramMessage = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzq
 * JD-Core Version:    0.7.0.1
 */
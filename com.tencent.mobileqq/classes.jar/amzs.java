import android.os.FileObserver;
import android.os.Handler;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneStartupMonitor;

public class amzs
  extends FileObserver
{
  public amzs(QZoneStartupMonitor paramQZoneStartupMonitor, String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (!"qzone_startup_monitor".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneStartupMonitor", 2, "path:" + paramString + ",非监控文件：" + "qzone_startup_monitor");
      }
      return;
    }
    switch (paramInt & 0xFFF)
    {
    default: 
      return;
    case 256: 
      paramInt = QzoneConfig.getInstance().getConfig("QZoneSetting", "startupFailTimeout", 60000);
      QZoneStartupMonitor.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneStartupMonitor", 2, "如果" + paramInt + "ms 后，未收到启动成功的消息，则认为启动失败");
      }
      QZoneStartupMonitor.a(this.a).sendEmptyMessageDelayed(1, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneStartupMonitor", 2, "启动成功，清理超时，并校验odex和上报");
    }
    QZoneStartupMonitor.a(this.a).removeMessages(1);
    paramString = QZoneStartupMonitor.a(BaseApplicationImpl.getApplication(), "qzone_plugin.apk");
    if (paramString != null) {}
    for (paramInt = ((Integer)paramString.first).intValue();; paramInt = 0)
    {
      QZoneStartupMonitor.a(this.a, true);
      QZoneStartupMonitor.a(this.a, paramInt, QZoneStartupMonitor.a(this.a), LocalMultiProcConfig.getInt("key_recovery_count", 0));
      LocalMultiProcConfig.putInt("key_recovery_count", 0);
      return;
    }
  }
  
  public void startWatching()
  {
    super.startWatching();
    QLog.i("QZoneStartupMonitor", 1, "startWatching");
  }
  
  public void stopWatching()
  {
    super.stopWatching();
    QLog.i("QZoneStartupMonitor", 1, "stopWatching");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzs
 * JD-Core Version:    0.7.0.1
 */
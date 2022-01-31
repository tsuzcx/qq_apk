import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class amxl
  extends PortConfigStrategy
  implements QzoneConfig.QzoneConfigChangeListener
{
  public amxl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "defaultPortStrategy={'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}");
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new amxm(this));
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void b()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginDownloadPortConfig", 2, "initPort, ports=" + str);
      }
      a(str);
    }
  }
  
  private void c()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null) {}
    for (;;)
    {
      a(str);
      return;
      str = "{'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}";
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "QzoneDownloadPortConfig receive change");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxl
 * JD-Core Version:    0.7.0.1
 */
import common.config.service.QZoneConfigHelper.LoadIntConfigCallback;
import common.config.service.QzoneConfig;

public final class ampv
  implements Runnable
{
  public ampv(QZoneConfigHelper.LoadIntConfigCallback paramLoadIntConfigCallback) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoView", "ShowOPDelay", 0);
    this.a.a(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ampv
 * JD-Core Version:    0.7.0.1
 */
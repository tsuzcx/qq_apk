import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class amxi
  extends IPConfigStrategy
  implements QzoneConfig.QzoneConfigChangeListener
{
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  
  public amxi()
  {
    a(2);
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void a(Map paramMap, String paramString1, String paramString2)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    String str = paramString1 + "||" + paramString2;
    paramString1 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadBackupConfig", 2, "addConfigItem, newKey=" + str + ", content=" + paramString1);
    }
    paramMap.put(str, paramString1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoSvrList", "DownloadBackupIP");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_backupIplist");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoABSvrList", "DownloadBackupIP_a");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_backupIplist_a");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoABSvrList", "DownloadBackupIP_b");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_backupIplist_b");
    a(this.jdField_a_of_type_JavaUtilMap, "VideoSvrList", "DownloadBackupIPVideo");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "video_backupIplist");
    super.a(this.jdField_a_of_type_JavaUtilMap);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QZonePluginDownloadBackupConfig receive change");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxi
 * JD-Core Version:    0.7.0.1
 */
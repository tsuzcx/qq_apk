import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import cooperation.qzone.plugin.QZonePluginManager;
import java.util.Properties;

public class amxv
  implements Runnable
{
  public amxv(QZonePluginManager paramQZonePluginManager, String paramString, int paramInt) {}
  
  public void run()
  {
    Properties localProperties = new Properties();
    localProperties.put("plugin_id", this.jdField_a_of_type_JavaLangString);
    localProperties.put("refer", String.valueOf(this.jdField_a_of_type_Int));
    MTAReportController.a(BaseApplicationImpl.getContext()).reportKVEvent("QzonePluginDownloadRefer", localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxv
 * JD-Core Version:    0.7.0.1
 */
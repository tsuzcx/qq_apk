import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.plugin.IQZonePluginManager;

public class anat
  implements Runnable
{
  public anat(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity, PluginBaseInfo paramPluginBaseInfo) {}
  
  public void run()
  {
    try
    {
      if (QzoneVerticalVideoDownloadActivity.a(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity) != null) {
        QzoneVerticalVideoDownloadActivity.a(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity).a(this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.mID, null, QzoneVerticalVideoDownloadActivity.a(this.jdField_a_of_type_CooperationQzoneQzoneVerticalVideoDownloadActivity));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import java.util.concurrent.ConcurrentLinkedQueue;

class annl
  extends OnPluginInstallListener.Stub
{
  annl(annj paramannj) {}
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.jdField_a_of_type_JavaLangString, 2, "Troop plugin onInstallBegin...  pluginId = " + this.a.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.jdField_a_of_type_JavaLangString, 2, "Troop plugin onInstallDownloadProgress... pluginId = " + this.a.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.jdField_a_of_type_JavaLangString, 2, "Troop plugin onInstallError... = " + this.a.jdField_a_of_type_JavaLangString);
    }
    this.a.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramString);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 1, null, null, null, null);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.jdField_a_of_type_JavaLangString, 2, "Troop plugin onInstallFinish...   pluginId = " + this.a.jdField_a_of_type_JavaLangString);
    }
    this.a.jdField_a_of_type_CooperationTroopTroopPluginManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramString);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 0, null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annl
 * JD-Core Version:    0.7.0.1
 */
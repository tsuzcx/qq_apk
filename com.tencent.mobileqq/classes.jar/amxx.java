import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginInstaller;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginManager.LaunchState;

public class amxx
  extends OnQZonePluginInstallListner.Stub
{
  private QZonePluginManager.LaunchState jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState;
  
  public amxx(QZonePluginManager paramQZonePluginManager, QZonePluginManager.LaunchState paramLaunchState)
  {
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState = paramLaunchState;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallBegin." + paramString);
    }
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallDownloadProgress." + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallError." + paramString + "," + paramInt);
    }
    QZonePluginManager.LaunchState localLaunchState = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState;
    if ((localLaunchState != null) && (localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener != null))
    {
      paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager.a(paramString);
      if ((paramString != null) && (paramString.k != null)) {
        localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.c = paramString.k;
      }
      paramString = localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState;
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener != null))
    {
      PluginRecord localPluginRecord = QZonePluginManager.a(this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager).a(paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.b);
      if ((localPluginRecord != null) && (localPluginRecord.k != null)) {
        paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams.c = localPluginRecord.k;
      }
      paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxx
 * JD-Core Version:    0.7.0.1
 */
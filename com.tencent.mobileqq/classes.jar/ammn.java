import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginInstaller;
import cooperation.plugin.PluginManagerV2;
import cooperation.plugin.PluginManagerV2.LaunchState;

public class ammn
  extends OnPluginInstallListener.Stub
{
  private PluginManagerV2.LaunchState jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
  
  public ammn(PluginManagerV2 paramPluginManagerV2, PluginManagerV2.LaunchState paramLaunchState)
  {
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    PluginManagerV2.LaunchState localLaunchState = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((localLaunchState != null) && (localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c = paramString.mInstalledPath;
      }
      paramString = localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_CooperationPluginPluginManagerV2$LaunchState;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null))
    {
      PluginInfo localPluginInfo = PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).a(paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null)) {
        paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c = localPluginInfo.mInstalledPath;
      }
      paramString.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammn
 * JD-Core Version:    0.7.0.1
 */
import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class blxe
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private blxc jdField_a_of_type_Blxc;
  
  public blxe(blwy paramblwy, blxc paramblxc)
  {
    this.jdField_a_of_type_Blxc = paramblxc;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Blxc.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blxc.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Blxc.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Blxc.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blxc.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Blxc.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Blxc.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    blxc localblxc = this.jdField_a_of_type_Blxc;
    if ((localblxc != null) && (localblxc.jdField_a_of_type_Blwf != null))
    {
      paramString = this.jdField_a_of_type_Blwy.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localblxc.jdField_a_of_type_Blwh.c = paramString.mInstalledPath;
      }
      paramString = localblxc.jdField_a_of_type_Blwf;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localblxc.jdField_a_of_type_AndroidContentContext, localblxc.jdField_a_of_type_Blwh);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Blxc;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Blwf != null))
    {
      PluginInfo localPluginInfo = blwy.a(this.jdField_a_of_type_Blwy).a(paramString.jdField_a_of_type_Blwh.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Blwh.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Blwh.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Blwf.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Blwh);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Blwy.a(this.jdField_a_of_type_Blxc.jdField_a_of_type_Blwh.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxe
 * JD-Core Version:    0.7.0.1
 */
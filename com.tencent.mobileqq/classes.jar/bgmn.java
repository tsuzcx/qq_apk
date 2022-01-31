import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class bgmn
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bgml jdField_a_of_type_Bgml;
  
  public bgmn(bgmh parambgmh, bgml parambgml)
  {
    this.jdField_a_of_type_Bgml = parambgml;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bgml.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bgml.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bgml.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bgml.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bgml.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bgml.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bgml.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bgml localbgml = this.jdField_a_of_type_Bgml;
    if ((localbgml != null) && (localbgml.jdField_a_of_type_Bglo != null))
    {
      paramString = this.jdField_a_of_type_Bgmh.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbgml.jdField_a_of_type_Bglq.c = paramString.mInstalledPath;
      }
      paramString = localbgml.jdField_a_of_type_Bglo;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbgml.jdField_a_of_type_AndroidContentContext, localbgml.jdField_a_of_type_Bglq);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bgml;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bglo != null))
    {
      PluginInfo localPluginInfo = bgmh.a(this.jdField_a_of_type_Bgmh).a(paramString.jdField_a_of_type_Bglq.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bglq.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bglq.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bglo.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bglq);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bgmh.a(this.jdField_a_of_type_Bgml.jdField_a_of_type_Bglq.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmn
 * JD-Core Version:    0.7.0.1
 */
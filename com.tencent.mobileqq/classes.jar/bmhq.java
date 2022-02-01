import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class bmhq
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bmho jdField_a_of_type_Bmho;
  
  public bmhq(bmhk parambmhk, bmho parambmho)
  {
    this.jdField_a_of_type_Bmho = parambmho;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bmho.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bmho.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bmho.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bmho.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bmho.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bmho.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bmho.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bmho localbmho = this.jdField_a_of_type_Bmho;
    if ((localbmho != null) && (localbmho.jdField_a_of_type_Bmgr != null))
    {
      paramString = this.jdField_a_of_type_Bmhk.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbmho.jdField_a_of_type_Bmgt.c = paramString.mInstalledPath;
      }
      paramString = localbmho.jdField_a_of_type_Bmgr;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbmho.jdField_a_of_type_AndroidContentContext, localbmho.jdField_a_of_type_Bmgt);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bmho;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bmgr != null))
    {
      PluginInfo localPluginInfo = bmhk.a(this.jdField_a_of_type_Bmhk).a(paramString.jdField_a_of_type_Bmgt.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bmgt.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bmgt.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bmgr.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bmgt);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bmhk.a(this.jdField_a_of_type_Bmho.jdField_a_of_type_Bmgt.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhq
 * JD-Core Version:    0.7.0.1
 */
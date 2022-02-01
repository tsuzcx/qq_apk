import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class bklw
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bklu jdField_a_of_type_Bklu;
  
  public bklw(bklq parambklq, bklu parambklu)
  {
    this.jdField_a_of_type_Bklu = parambklu;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bklu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bklu.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bklu.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bklu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bklu.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bklu.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bklu.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bklu localbklu = this.jdField_a_of_type_Bklu;
    if ((localbklu != null) && (localbklu.jdField_a_of_type_Bkkx != null))
    {
      paramString = this.jdField_a_of_type_Bklq.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbklu.jdField_a_of_type_Bkkz.c = paramString.mInstalledPath;
      }
      paramString = localbklu.jdField_a_of_type_Bkkx;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbklu.jdField_a_of_type_AndroidContentContext, localbklu.jdField_a_of_type_Bkkz);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bklu;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bkkx != null))
    {
      PluginInfo localPluginInfo = bklq.a(this.jdField_a_of_type_Bklq).a(paramString.jdField_a_of_type_Bkkz.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bkkz.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bkkz.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bkkx.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bkkz);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bklq.a(this.jdField_a_of_type_Bklu.jdField_a_of_type_Bkkz.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklw
 * JD-Core Version:    0.7.0.1
 */
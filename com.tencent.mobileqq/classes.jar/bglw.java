import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class bglw
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bglu jdField_a_of_type_Bglu;
  
  public bglw(bglq parambglq, bglu parambglu)
  {
    this.jdField_a_of_type_Bglu = parambglu;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bglu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bglu.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bglu.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bglu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bglu.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bglu.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bglu.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bglu localbglu = this.jdField_a_of_type_Bglu;
    if ((localbglu != null) && (localbglu.jdField_a_of_type_Bgkx != null))
    {
      paramString = this.jdField_a_of_type_Bglq.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbglu.jdField_a_of_type_Bgkz.c = paramString.mInstalledPath;
      }
      paramString = localbglu.jdField_a_of_type_Bgkx;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbglu.jdField_a_of_type_AndroidContentContext, localbglu.jdField_a_of_type_Bgkz);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bglu;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bgkx != null))
    {
      PluginInfo localPluginInfo = bglq.a(this.jdField_a_of_type_Bglq).a(paramString.jdField_a_of_type_Bgkz.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bgkz.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bgkz.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bgkx.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bgkz);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bglq.a(this.jdField_a_of_type_Bglu.jdField_a_of_type_Bgkz.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglw
 * JD-Core Version:    0.7.0.1
 */
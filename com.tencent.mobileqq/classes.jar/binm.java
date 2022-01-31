import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class binm
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bink jdField_a_of_type_Bink;
  
  public binm(bing parambing, bink parambink)
  {
    this.jdField_a_of_type_Bink = parambink;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bink.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bink.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bink.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bink.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bink.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bink.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bink.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bink localbink = this.jdField_a_of_type_Bink;
    if ((localbink != null) && (localbink.jdField_a_of_type_Bimn != null))
    {
      paramString = this.jdField_a_of_type_Bing.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbink.jdField_a_of_type_Bimp.c = paramString.mInstalledPath;
      }
      paramString = localbink.jdField_a_of_type_Bimn;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbink.jdField_a_of_type_AndroidContentContext, localbink.jdField_a_of_type_Bimp);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bink;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bimn != null))
    {
      PluginInfo localPluginInfo = bing.a(this.jdField_a_of_type_Bing).a(paramString.jdField_a_of_type_Bimp.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bimp.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bimp.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bimn.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bimp);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bing.a(this.jdField_a_of_type_Bink.jdField_a_of_type_Bimp.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     binm
 * JD-Core Version:    0.7.0.1
 */
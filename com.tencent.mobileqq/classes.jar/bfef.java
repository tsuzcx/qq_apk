import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class bfef
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private bfed jdField_a_of_type_Bfed;
  
  public bfef(bfdz parambfdz, bfed parambfed)
  {
    this.jdField_a_of_type_Bfed = parambfed;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Bfed.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bfed.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Bfed.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Bfed.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bfed.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Bfed.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Bfed.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bfed localbfed = this.jdField_a_of_type_Bfed;
    if ((localbfed != null) && (localbfed.jdField_a_of_type_Bfdg != null))
    {
      paramString = this.jdField_a_of_type_Bfdz.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbfed.jdField_a_of_type_Bfdi.c = paramString.mInstalledPath;
      }
      paramString = localbfed.jdField_a_of_type_Bfdg;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbfed.jdField_a_of_type_AndroidContentContext, localbfed.jdField_a_of_type_Bfdi);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bfed;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Bfdg != null))
    {
      PluginInfo localPluginInfo = bfdz.a(this.jdField_a_of_type_Bfdz).a(paramString.jdField_a_of_type_Bfdi.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Bfdi.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Bfdi.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Bfdg.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bfdi);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Bfdz.a(this.jdField_a_of_type_Bfed.jdField_a_of_type_Bfdi.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfef
 * JD-Core Version:    0.7.0.1
 */
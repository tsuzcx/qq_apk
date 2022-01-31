import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class birt
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private birr jdField_a_of_type_Birr;
  
  public birt(birn parambirn, birr parambirr)
  {
    this.jdField_a_of_type_Birr = parambirr;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Birr.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Birr.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Birr.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Birr.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Birr.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Birr.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Birr.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    birr localbirr = this.jdField_a_of_type_Birr;
    if ((localbirr != null) && (localbirr.jdField_a_of_type_Biqu != null))
    {
      paramString = this.jdField_a_of_type_Birn.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbirr.jdField_a_of_type_Biqw.c = paramString.mInstalledPath;
      }
      paramString = localbirr.jdField_a_of_type_Biqu;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbirr.jdField_a_of_type_AndroidContentContext, localbirr.jdField_a_of_type_Biqw);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Birr;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Biqu != null))
    {
      PluginInfo localPluginInfo = birn.a(this.jdField_a_of_type_Birn).a(paramString.jdField_a_of_type_Biqw.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Biqw.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Biqw.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Biqu.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Biqw);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Birn.a(this.jdField_a_of_type_Birr.jdField_a_of_type_Biqw.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birt
 * JD-Core Version:    0.7.0.1
 */
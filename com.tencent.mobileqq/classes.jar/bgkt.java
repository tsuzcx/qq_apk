import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class bgkt
  extends OnPluginInstallListener.Stub
{
  bgkt(bgkx parambgkx, bgkz parambgkz, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Bgkx != null) {
      this.jdField_a_of_type_Bgkx.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgkz);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Bgkx != null)
    {
      paramString = bgkq.a().queryPlugin(this.jdField_a_of_type_Bgkz.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Bgkz.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Bgkz.a(paramString);
      }
      this.jdField_a_of_type_Bgkx.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgkz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkt
 * JD-Core Version:    0.7.0.1
 */
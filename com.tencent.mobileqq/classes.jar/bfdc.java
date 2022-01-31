import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class bfdc
  extends OnPluginInstallListener.Stub
{
  bfdc(bfdg parambfdg, bfdi parambfdi, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Bfdg != null) {
      this.jdField_a_of_type_Bfdg.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfdi);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Bfdg != null)
    {
      paramString = bfcz.a().queryPlugin(this.jdField_a_of_type_Bfdi.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Bfdi.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Bfdi.a(paramString);
      }
      this.jdField_a_of_type_Bfdg.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfdi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfdc
 * JD-Core Version:    0.7.0.1
 */
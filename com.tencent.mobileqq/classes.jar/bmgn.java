import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class bmgn
  extends OnPluginInstallListener.Stub
{
  bmgn(bmgr parambmgr, bmgt parambmgt, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Bmgr != null) {
      this.jdField_a_of_type_Bmgr.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmgt);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Bmgr != null)
    {
      paramString = bmgk.a().queryPlugin(this.jdField_a_of_type_Bmgt.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Bmgt.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Bmgt.a(paramString);
      }
      this.jdField_a_of_type_Bmgr.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmgt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgn
 * JD-Core Version:    0.7.0.1
 */
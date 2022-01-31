import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class bglk
  extends OnPluginInstallListener.Stub
{
  bglk(bglo parambglo, bglq parambglq, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Bglo != null) {
      this.jdField_a_of_type_Bglo.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bglq);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Bglo != null)
    {
      paramString = bglh.a().queryPlugin(this.jdField_a_of_type_Bglq.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Bglq.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Bglq.a(paramString);
      }
      this.jdField_a_of_type_Bglo.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bglq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglk
 * JD-Core Version:    0.7.0.1
 */
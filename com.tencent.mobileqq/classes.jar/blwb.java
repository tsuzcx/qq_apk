import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class blwb
  extends OnPluginInstallListener.Stub
{
  blwb(blwf paramblwf, blwh paramblwh, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Blwf != null) {
      this.jdField_a_of_type_Blwf.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blwh);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Blwf != null)
    {
      paramString = blvy.a().queryPlugin(this.jdField_a_of_type_Blwh.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Blwh.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Blwh.a(paramString);
      }
      this.jdField_a_of_type_Blwf.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blwh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwb
 * JD-Core Version:    0.7.0.1
 */
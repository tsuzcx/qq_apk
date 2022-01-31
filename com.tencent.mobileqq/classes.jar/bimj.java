import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class bimj
  extends OnPluginInstallListener.Stub
{
  bimj(bimn parambimn, bimp parambimp, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    if (this.jdField_a_of_type_Bimn != null) {
      this.jdField_a_of_type_Bimn.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bimp);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.jdField_a_of_type_Bimn != null)
    {
      paramString = bimg.a().queryPlugin(this.jdField_a_of_type_Bimp.b);
      if (paramString != null)
      {
        this.jdField_a_of_type_Bimp.c = paramString.mInstalledPath;
        this.jdField_a_of_type_Bimp.a(paramString);
      }
      this.jdField_a_of_type_Bimn.a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bimp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimj
 * JD-Core Version:    0.7.0.1
 */
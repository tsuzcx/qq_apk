import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

class blgn
  extends OnPluginInstallListener.Stub
{
  long jdField_a_of_type_Long = 0L;
  private blgl jdField_a_of_type_Blgl;
  
  public blgn(blgh paramblgh, blgl paramblgl)
  {
    this.jdField_a_of_type_Blgl = paramblgl;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallBegin." + paramString);
    }
    if ((!this.jdField_a_of_type_Blgl.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blgl.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      this.jdField_a_of_type_Blgl.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + paramString);
    }
    if ((!this.jdField_a_of_type_Blgl.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blgl.jdField_a_of_type_AndroidAppProgressDialog != null))
    {
      this.jdField_a_of_type_Blgl.jdField_a_of_type_AndroidAppProgressDialog.setMax(paramInt2);
      this.jdField_a_of_type_Blgl.jdField_a_of_type_AndroidAppProgressDialog.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallError." + paramString + "," + paramInt);
    }
    blgl localblgl = this.jdField_a_of_type_Blgl;
    if ((localblgl != null) && (localblgl.jdField_a_of_type_Blfo != null))
    {
      paramString = this.jdField_a_of_type_Blgh.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localblgl.jdField_a_of_type_Blfq.c = paramString.mInstalledPath;
      }
      paramString = localblgl.jdField_a_of_type_Blfo;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localblgl.jdField_a_of_type_AndroidContentContext, localblgl.jdField_a_of_type_Blfq);
      return;
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Blgl;
    if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_AndroidAppProgressDialog != null)) {
      paramString.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
    if ((paramString != null) && (paramString.jdField_a_of_type_Blfo != null))
    {
      PluginInfo localPluginInfo = blgh.a(this.jdField_a_of_type_Blgh).a(paramString.jdField_a_of_type_Blfq.b);
      if ((localPluginInfo != null) && (localPluginInfo.mInstalledPath != null))
      {
        paramString.jdField_a_of_type_Blfq.c = localPluginInfo.mInstalledPath;
        paramString.jdField_a_of_type_Blfq.a(localPluginInfo);
      }
      paramString.jdField_a_of_type_Blfo.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Blfq);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Blgh.a(this.jdField_a_of_type_Blgl.jdField_a_of_type_Blfq.b, "pluginDownloadCost", l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgn
 * JD-Core Version:    0.7.0.1
 */
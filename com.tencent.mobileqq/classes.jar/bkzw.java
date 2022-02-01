import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class bkzw
  implements OnPluginInstallListener
{
  bkzw(AppRuntime paramAppRuntime, bkzr parambkzr, bkzx parambkzx, int paramInt) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.jdField_a_of_type_Bkzr.b + " preload:fail:installerror");
    }
    bkzp.a(this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_Bkzr.b, this.jdField_a_of_type_Bkzr.c, 3, "preload:fail:installerror", this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bkzr.d) });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    bkzp.a(this.jdField_a_of_type_MqqAppAppRuntime, 0, this.jdField_a_of_type_Bkzr.b, this.jdField_a_of_type_Bkzr.c, this.jdField_a_of_type_Bkzx.jdField_a_of_type_Int, this.jdField_a_of_type_Bkzx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bkzr.d) });
    this.jdField_a_of_type_Bkzr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzw
 * JD-Core Version:    0.7.0.1
 */
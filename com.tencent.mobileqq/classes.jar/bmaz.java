import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class bmaz
  implements OnPluginInstallListener
{
  bmaz(AppRuntime paramAppRuntime, bmau parambmau, bmba parambmba, int paramInt) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.jdField_a_of_type_Bmau.b + " preload:fail:installerror");
    }
    bmas.a(this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_Bmau.b, this.jdField_a_of_type_Bmau.c, 3, "preload:fail:installerror", this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bmau.d) });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    bmas.a(this.jdField_a_of_type_MqqAppAppRuntime, 0, this.jdField_a_of_type_Bmau.b, this.jdField_a_of_type_Bmau.c, this.jdField_a_of_type_Bmba.jdField_a_of_type_Int, this.jdField_a_of_type_Bmba.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bmau.d) });
    this.jdField_a_of_type_Bmau.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmaz
 * JD-Core Version:    0.7.0.1
 */
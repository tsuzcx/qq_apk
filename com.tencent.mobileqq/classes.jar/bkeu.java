import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class bkeu
  implements OnPluginInstallListener
{
  bkeu(AppRuntime paramAppRuntime, bkep parambkep, bkev parambkev, int paramInt) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.jdField_a_of_type_Bkep.b + " preload:fail:installerror");
    }
    bken.a(this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_Bkep.b, this.jdField_a_of_type_Bkep.c, 3, "preload:fail:installerror", this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bkep.d) });
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    bken.a(this.jdField_a_of_type_MqqAppAppRuntime, 0, this.jdField_a_of_type_Bkep.b, this.jdField_a_of_type_Bkep.c, this.jdField_a_of_type_Bkev.jdField_a_of_type_Int, this.jdField_a_of_type_Bkev.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Bkep.d) });
    this.jdField_a_of_type_Bkep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeu
 * JD-Core Version:    0.7.0.1
 */
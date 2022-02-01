import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class apks
  implements ServiceConnection
{
  apks(apkr paramapkr) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Apln = aplo.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.a.jdField_a_of_type_Apln);
    }
    if (this.a.jdField_a_of_type_Apln != null) {}
    try
    {
      this.a.jdField_a_of_type_Apln.a(this.a.jdField_a_of_type_Aplz);
      this.a.jdField_a_of_type_Apln.a(this.a.jdField_a_of_type_Aplq);
      this.a.jdField_a_of_type_Apln.a(apkr.a(this.a));
      this.a.jdField_a_of_type_Apln.a(this.a.jdField_a_of_type_Aplw);
      if (apkr.a(this.a) != -1) {
        this.a.jdField_a_of_type_Apln.c(apkr.a(this.a));
      }
      if (apkr.a(this.a) != null) {
        apkr.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (apkr.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          apkr.a(this.a).sendMessage(paramComponentName);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (apkr.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        apkr.a(this.a).sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.a.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (apkr.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        apkr.a(this.a).sendMessage(paramComponentName);
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "registerArCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a.jdField_a_of_type_Apln != null) {}
    try
    {
      this.a.jdField_a_of_type_Apln.b(this.a.jdField_a_of_type_Aplz);
      this.a.jdField_a_of_type_Apln.b(this.a.jdField_a_of_type_Aplq);
      this.a.jdField_a_of_type_Apln.b(apkr.a(this.a));
      this.a.jdField_a_of_type_Apln.b(this.a.jdField_a_of_type_Aplw);
      this.a.jdField_a_of_type_Apln = null;
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "unregisterCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apks
 * JD-Core Version:    0.7.0.1
 */
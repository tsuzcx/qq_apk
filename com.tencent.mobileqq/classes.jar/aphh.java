import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class aphh
  implements ServiceConnection
{
  aphh(aphg paramaphg) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Apic = apid.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.a.jdField_a_of_type_Apic);
    }
    if (this.a.jdField_a_of_type_Apic != null) {}
    try
    {
      this.a.jdField_a_of_type_Apic.a(this.a.jdField_a_of_type_Apio);
      this.a.jdField_a_of_type_Apic.a(this.a.jdField_a_of_type_Apif);
      this.a.jdField_a_of_type_Apic.a(aphg.a(this.a));
      this.a.jdField_a_of_type_Apic.a(this.a.jdField_a_of_type_Apil);
      if (aphg.a(this.a) != -1) {
        this.a.jdField_a_of_type_Apic.c(aphg.a(this.a));
      }
      if (aphg.a(this.a) != null) {
        aphg.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (aphg.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          aphg.a(this.a).sendMessage(paramComponentName);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (aphg.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        aphg.a(this.a).sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.a.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (aphg.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        aphg.a(this.a).sendMessage(paramComponentName);
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
    if (this.a.jdField_a_of_type_Apic != null) {}
    try
    {
      this.a.jdField_a_of_type_Apic.b(this.a.jdField_a_of_type_Apio);
      this.a.jdField_a_of_type_Apic.b(this.a.jdField_a_of_type_Apif);
      this.a.jdField_a_of_type_Apic.b(aphg.a(this.a));
      this.a.jdField_a_of_type_Apic.b(this.a.jdField_a_of_type_Apil);
      this.a.jdField_a_of_type_Apic = null;
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
 * Qualified Name:     aphh
 * JD-Core Version:    0.7.0.1
 */
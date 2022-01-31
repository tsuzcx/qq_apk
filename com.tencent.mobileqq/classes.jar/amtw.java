import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class amtw
  implements ServiceConnection
{
  amtw(amtv paramamtv) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Amur = amus.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.a.jdField_a_of_type_Amur);
    }
    if (this.a.jdField_a_of_type_Amur != null) {}
    try
    {
      this.a.jdField_a_of_type_Amur.a(this.a.jdField_a_of_type_Amvd);
      this.a.jdField_a_of_type_Amur.a(this.a.jdField_a_of_type_Amuu);
      this.a.jdField_a_of_type_Amur.a(amtv.a(this.a));
      this.a.jdField_a_of_type_Amur.a(this.a.jdField_a_of_type_Amva);
      if (amtv.a(this.a) != -1) {
        this.a.jdField_a_of_type_Amur.c(amtv.a(this.a));
      }
      if (amtv.a(this.a) != null) {
        amtv.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (amtv.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          amtv.a(this.a).sendMessage(paramComponentName);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (amtv.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        amtv.a(this.a).sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.a.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (amtv.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        amtv.a(this.a).sendMessage(paramComponentName);
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
    if (this.a.jdField_a_of_type_Amur != null) {}
    try
    {
      this.a.jdField_a_of_type_Amur.b(this.a.jdField_a_of_type_Amvd);
      this.a.jdField_a_of_type_Amur.b(this.a.jdField_a_of_type_Amuu);
      this.a.jdField_a_of_type_Amur.b(amtv.a(this.a));
      this.a.jdField_a_of_type_Amur.b(this.a.jdField_a_of_type_Amva);
      this.a.jdField_a_of_type_Amur = null;
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
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */
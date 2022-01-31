import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;

class bjpu
  extends bjol
  implements bjul
{
  private static int jdField_a_of_type_Int;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_live_video_plugin_hack.apk", "qzone_vertical_video_plugin.apk" };
  private Handler jdField_a_of_type_AndroidOsHandler = new bjpv(this, Looper.getMainLooper());
  private bjpo jdField_a_of_type_Bjpo;
  private bjpw jdField_a_of_type_Bjpw;
  
  bjpu(bjpo parambjpo, bjpw parambjpw)
  {
    this.jdField_a_of_type_Bjpw = parambjpw;
    this.jdField_a_of_type_Bjpo = parambjpo;
    NetworkState.addListener(this);
  }
  
  void a()
  {
    if ((bjpo.b()) && (this.jdField_a_of_type_Bjpw.a() != null)) {
      try
      {
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_Bjpo.a(str, this, 0);
          i += 1;
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZonePluginPreInstaller", 1, localRemoteException, new Object[0]);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallBegin");
    }
  }
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallError, plugin=" + paramString + ", retryInstallNum=" + jdField_a_of_type_Int);
    }
    paramInt = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
    if ((jdField_a_of_type_Int < paramInt) && (this.jdField_a_of_type_Bjpo != null))
    {
      jdField_a_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, jdField_a_of_type_Int * 30 * 1000);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_a_of_type_Int = 0;
    NetworkState.removeListener(this);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallFinish");
    }
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (bjpo.b()) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpu
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;

class bnff
  extends bndw
  implements bnjy
{
  private static int jdField_a_of_type_Int;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_live_video_plugin_hack.apk", "qzone_vertical_video_plugin.apk" };
  private Handler jdField_a_of_type_AndroidOsHandler = new bnfg(this, Looper.getMainLooper());
  private bnez jdField_a_of_type_Bnez;
  private bnfh jdField_a_of_type_Bnfh;
  
  bnff(bnez parambnez, bnfh parambnfh)
  {
    this.jdField_a_of_type_Bnfh = parambnfh;
    this.jdField_a_of_type_Bnez = parambnez;
    NetworkState.addListener(this);
  }
  
  void a()
  {
    if ((bnez.b()) && (this.jdField_a_of_type_Bnfh.a() != null)) {
      try
      {
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_Bnez.a(str, this, 0);
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
    if ((jdField_a_of_type_Int < paramInt) && (this.jdField_a_of_type_Bnez != null))
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
    if (bnez.b()) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnff
 * JD-Core Version:    0.7.0.1
 */
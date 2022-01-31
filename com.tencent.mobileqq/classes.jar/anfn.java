import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginUpdater;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

public class anfn
  extends OnQZonePluginInstallListner.Stub
  implements NetworkState.NetworkStateListener
{
  private static int jdField_a_of_type_Int;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_live_video_plugin_hack.apk", "qzone_vertical_video_plugin.apk" };
  private Handler jdField_a_of_type_AndroidOsHandler = new anfo(this, Looper.getMainLooper());
  private QZonePluginManager jdField_a_of_type_CooperationQzonePluginQZonePluginManager;
  private QZonePluginUpdater jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater;
  
  public anfn(QZonePluginManager paramQZonePluginManager, QZonePluginUpdater paramQZonePluginUpdater)
  {
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater = paramQZonePluginUpdater;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager = paramQZonePluginManager;
    NetworkState.addListener(this);
  }
  
  public void a()
  {
    if ((QZonePluginManager.b()) && (this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a() != null)) {
      try
      {
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager.a(str, this, 0);
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
    if ((jdField_a_of_type_Int < paramInt) && (this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager != null))
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
    if (QZonePluginManager.b()) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */
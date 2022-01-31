import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import common.config.service.QzoneConfig;
import cooperation.qzone.Native;
import cooperation.qzone.util.QZLog;

public final class bhax
  implements IUploadEnv, IUploadSoLoader
{
  bhaz jdField_a_of_type_Bhaz = new bhaz();
  private volatile boolean jdField_a_of_type_Boolean = true;
  
  public bhax()
  {
    this.jdField_a_of_type_Bhaz.a();
  }
  
  public static int a(int paramInt)
  {
    if (!a(paramInt)) {
      return 1;
    }
    try
    {
      paramInt = com.tencent.upload.network.NetworkState.getNetworkStackType();
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QZLog.e("UploadEnv", "getIpStack error", localUnsatisfiedLinkError);
    }
    return 1;
  }
  
  private static NetworkInfo a(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {}
      for (paramContext = "getActiveNetworkInfo null";; paramContext = localNetworkInfo.toString())
      {
        QLog.d("UploadEnv", 1, paramContext);
        return localNetworkInfo;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      QLog.d("UploadEnv", 1, "fail to get active network info " + paramContext.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    int i = QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadEnableV6RouteForAll", 7);
    if (paramInt != 1) {
      QZLog.d("UploadEnv", 1, "enableV6Switch:" + (i >> paramInt & 0x1) + " type:" + paramInt);
    }
    return (i >> paramInt & 0x1) == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public String getApnName()
  {
    return cooperation.qzone.util.NetworkState.getAPN();
  }
  
  public String getBSSID()
  {
    return bbct.b(BaseApplication.getContext());
  }
  
  public int getBatchControlCount()
  {
    return 8;
  }
  
  public int getCurrentNetworkCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public int getFileConcurrentCount()
  {
    return 3;
  }
  
  public int getMobileOperatorCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public String getProviderName()
  {
    return cooperation.qzone.util.NetworkState.getProviderName();
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return bbuv.a(paramString);
  }
  
  public String getSoVersion()
  {
    return "v1.3";
  }
  
  public int getSocketCount()
  {
    return 2;
  }
  
  public boolean isAvailable()
  {
    boolean bool = cooperation.qzone.util.NetworkState.isNetSupport();
    this.jdField_a_of_type_Boolean = a(BaseApplication.getContext());
    QLog.d("upload2:", 2, "msf network isAvailable:" + bool + " observer:" + this.jdField_a_of_type_Boolean);
    return (bool) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean isMobile()
  {
    return cooperation.qzone.util.NetworkState.isMobile();
  }
  
  public boolean isWap()
  {
    return cooperation.qzone.util.NetworkState.isWap();
  }
  
  public boolean isWifi()
  {
    return cooperation.qzone.util.NetworkState.isWifiConn();
  }
  
  public boolean loadLibrary(String paramString)
  {
    boolean bool = this.jdField_a_of_type_Bhaz.a(paramString);
    QLog.d("UploadEnv", 1, "useDownloadedSo " + bool);
    if (bool) {
      return true;
    }
    QLog.d("UploadEnv", 1, "loadLibrary " + paramString);
    return Native.a(paramString, BaseApplication.getContext());
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver");
    }
    cooperation.qzone.util.NetworkState.addListener(new bhay(this, paramNetworkStateObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhax
 * JD-Core Version:    0.7.0.1
 */
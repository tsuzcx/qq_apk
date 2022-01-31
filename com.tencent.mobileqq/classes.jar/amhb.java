import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener;
import cooperation.qzone.plugin.OnQZonePluginInstallListner;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZoneRemotePluginManager;

public class amhb
  extends IQZonePluginManager
{
  QZoneRemotePluginManager a;
  
  amhb(QZoneRemotePluginManager paramQZoneRemotePluginManager)
  {
    this.a = paramQZoneRemotePluginManager;
  }
  
  public PluginRecord a(String paramString)
  {
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NullPointerException paramString)
    {
      for (;;)
      {
        QLog.w("QZonePluginClient", 1, "", paramString);
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QZonePluginClient", 1, localNullPointerException, new Object[0]);
    }
  }
  
  public void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    try
    {
      a(paramPluginParams.b, new amhc(this, paramOnPluginReadyListener, paramContext, paramPluginParams), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    try
    {
      this.a.a(paramOnQZoneLiveSoDownloadListener, paramInt);
      return;
    }
    catch (NullPointerException paramOnQZoneLiveSoDownloadListener)
    {
      QLog.e("QZonePluginClient", 1, paramOnQZoneLiveSoDownloadListener, new Object[0]);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a.a();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = this.a.a(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    try
    {
      boolean bool = this.a.a(paramString, paramOnQZonePluginInstallListner, paramInt);
      return bool;
    }
    catch (NullPointerException paramString)
    {
      QLog.e("QZonePluginClient", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.a != null)
      {
        IBinder localIBinder = this.a.asBinder();
        bool1 = bool2;
        if (localIBinder != null)
        {
          bool1 = bool2;
          if (localIBinder.isBinderAlive())
          {
            boolean bool3 = localIBinder.pingBinder();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean b(String paramString)
  {
    try
    {
      boolean bool = this.a.b(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    try
    {
      boolean bool = this.a.c(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhb
 * JD-Core Version:    0.7.0.1
 */
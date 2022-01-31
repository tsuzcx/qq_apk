import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bgab
  extends bfzg
{
  bgbi a;
  
  bgab(bgbi parambgbi)
  {
    this.a = parambgbi;
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
  
  public void a(Context paramContext, bfzm parambfzm, bfzl parambfzl)
  {
    try
    {
      a(parambfzm.b, new bgac(this, parambfzl, paramContext, parambfzm), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(bfzn parambfzn, int paramInt)
  {
    try
    {
      this.a.a(parambfzn, paramInt);
      return;
    }
    catch (NullPointerException parambfzn)
    {
      QLog.e("QZonePluginClient", 1, parambfzn, new Object[0]);
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
  
  public boolean a(String paramString, bfzq parambfzq, int paramInt)
  {
    try
    {
      boolean bool = this.a.a(paramString, parambfzq, paramInt);
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
  
  boolean b()
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
 * Qualified Name:     bgab
 * JD-Core Version:    0.7.0.1
 */
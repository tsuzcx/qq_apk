import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bneg
  extends bndl
{
  bnfn a;
  
  bneg(bnfn parambnfn)
  {
    this.a = parambnfn;
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
  
  public void a(Context paramContext, bndr parambndr, bndq parambndq)
  {
    try
    {
      a(parambndr.b, new bneh(this, parambndq, paramContext, parambndr), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(bnds parambnds, int paramInt)
  {
    try
    {
      this.a.a(parambnds, paramInt);
      return;
    }
    catch (NullPointerException parambnds)
    {
      QLog.e("QZonePluginClient", 1, parambnds, new Object[0]);
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
  
  public boolean a(String paramString, bndv parambndv, int paramInt)
  {
    try
    {
      boolean bool = this.a.a(paramString, parambndv, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneg
 * JD-Core Version:    0.7.0.1
 */
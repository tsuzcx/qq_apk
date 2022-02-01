package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArFaceCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.qphone.base.util.QLog;

public class RemoteArConfigManager
  implements Handler.Callback
{
  public ArConfigInfo a;
  public ArEffectConfig b;
  public ARCommonConfigInfo c;
  public IArConfigListener d;
  public IArFaceResourceListener e;
  public IArConfigManager f = null;
  public boolean g = false;
  volatile boolean h = false;
  boolean i = false;
  public ServiceConnection j = new RemoteArConfigManager.1(this);
  public IArRemoteCallback k = new RemoteArConfigManager.2(this);
  public IArFaceCallback l = new RemoteArConfigManager.3(this);
  private Context m;
  private HandlerThread n = new HandlerThread("RemoteArConfigManager");
  private Handler o;
  private IArSoListener p;
  private IArSoCallback q = new RemoteArConfigManager.4(this);
  private int r = -1;
  
  public RemoteArConfigManager()
  {
    this.n.start();
    this.o = new Handler(this.n.getLooper(), this);
  }
  
  public void a()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.n = null;
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.o = null;
    }
    if (this.g)
    {
      e();
      this.g = false;
    }
    if (this.h)
    {
      localObject = this.m;
      if (localObject != null) {
        try
        {
          ((Context)localObject).unbindService(this.j);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      this.h = false;
      this.m = null;
    }
    this.d = null;
    this.e = null;
    this.p = null;
  }
  
  public void a(int paramInt)
  {
    if (this.f != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("downloadFaceResources type ");
        localStringBuilder1.append(paramInt);
        QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder1.toString());
      }
      try
      {
        this.f.a(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("downloadFaceResources|RemoteException e= ");
          localStringBuilder2.append(localRemoteException);
          QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder2.toString());
        }
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean, IArConfigListener paramIArConfigListener, IArFaceResourceListener paramIArFaceResourceListener, IArSoListener paramIArSoListener)
  {
    if (paramContext == null) {
      return;
    }
    this.m = paramContext;
    this.i = paramBoolean;
    paramContext = new Intent(this.m, ArConfigService.class);
    this.m.bindService(paramContext, this.j, 1);
    this.h = true;
    if (paramIArConfigListener != null) {
      this.d = paramIArConfigListener;
    }
    if (paramIArFaceResourceListener != null) {
      this.e = paramIArFaceResourceListener;
    }
    this.p = paramIArSoListener;
  }
  
  public ArConfigInfo b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    StringBuilder localStringBuilder = null;
    IArConfigManager localIArConfigManager = this.f;
    localObject = localStringBuilder;
    if (localIArConfigManager != null) {
      try
      {
        localObject = localIArConfigManager.a();
      }
      catch (RemoteException localRemoteException)
      {
        localObject = localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getArConfig|RemoteException e= ");
          ((StringBuilder)localObject).append(localRemoteException);
          QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
          localObject = localStringBuilder;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getArConfig|info=");
      localStringBuilder.append(localObject);
      QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onToolScannerActivityStateChanged state:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  mConfigManager:");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    if (localObject != null) {
      try
      {
        ((IArConfigManager)localObject).b(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    this.r = paramInt;
  }
  
  public ArEffectConfig c()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = null;
    Object localObject4 = null;
    localObject1 = this.f;
    Object localObject3;
    if (localObject1 != null)
    {
      try
      {
        localObject1 = ((IArConfigManager)localObject1).b();
      }
      catch (RemoteException localRemoteException)
      {
        localObject1 = localObject4;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getEffectConfig|RemoteException e= ");
          ((StringBuilder)localObject1).append(localRemoteException);
          QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject4;
        }
      }
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getEffectConfig|info=");
        ((StringBuilder)localObject3).append(localObject1);
        QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject3).toString());
        localObject3 = localObject1;
      }
    }
    return localObject3;
  }
  
  public ARCommonConfigInfo d()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      return localObject1;
    }
    ARCommonConfigInfo localARCommonConfigInfo = null;
    localObject1 = null;
    IArConfigManager localIArConfigManager = this.f;
    Object localObject2;
    if (localIArConfigManager != null)
    {
      try
      {
        localARCommonConfigInfo = localIArConfigManager.c();
        localObject1 = localARCommonConfigInfo;
      }
      catch (Exception localException)
      {
        QLog.d("ArConfig_RemoteArConfigManager", 1, "getARCommonConfigInfo fail!", localException);
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject1 }));
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public void e()
  {
    if (this.f != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
      try
      {
        this.f.e();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cancelDownload|RemoteException e= ");
          localStringBuilder.append(localRemoteException);
          QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public boolean f()
  {
    IArConfigManager localIArConfigManager = this.f;
    boolean bool2 = false;
    boolean bool3 = false;
    if (localIArConfigManager != null)
    {
      boolean bool1;
      try
      {
        bool1 = localIArConfigManager.f();
      }
      catch (RemoteException localRemoteException)
      {
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("isFaceResConfigReady|RemoteException e= ");
          localStringBuilder2.append(localRemoteException);
          QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder2.toString());
          bool1 = bool3;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("isFaceResConfigReady ");
        localStringBuilder1.append(bool1);
        QLog.d("ArConfig_RemoteArConfigManager", 2, localStringBuilder1.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean g()
  {
    IArConfigManager localIArConfigManager = this.f;
    if (localIArConfigManager != null) {
      try
      {
        boolean bool = localIArConfigManager.g();
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isArSoReady fail!", localException);
        }
      }
    }
    return false;
  }
  
  public void h()
  {
    IArConfigManager localIArConfigManager = this.f;
    if (localIArConfigManager != null) {
      try
      {
        localIArConfigManager.h();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadArSo fail!", localException);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    int i2;
    switch (i1)
    {
    default: 
      switch (i1)
      {
      default: 
        return false;
      case 102: 
        IArSoListener localIArSoListener = this.p;
        if (localIArSoListener != null)
        {
          localIArSoListener.b(paramMessage.arg1);
          return false;
        }
        break;
      case 101: 
        paramMessage = this.p;
        if (paramMessage != null)
        {
          paramMessage.d();
          return false;
        }
        break;
      case 100: 
        paramMessage = this.p;
        if (paramMessage != null)
        {
          paramMessage.c();
          return false;
        }
        break;
      }
      break;
    case 9: 
      if (this.d != null) {
        try
        {
          if ((paramMessage.obj instanceof ARCommonConfigInfo))
          {
            this.d.a((ARCommonConfigInfo)paramMessage.obj);
            return false;
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("ArConfig_RemoteArConfigManager", 1, "handleMessage AR_COMMON_CONFIG_UPDATE fail.", paramMessage);
          return false;
        }
      }
      break;
    case 8: 
      if (this.e != null)
      {
        i1 = paramMessage.arg1;
        i2 = paramMessage.arg2;
        this.e.b(i1, i2);
        return false;
      }
      break;
    case 7: 
      if (this.e != null)
      {
        i1 = paramMessage.arg1;
        i2 = paramMessage.arg2;
        this.e.a(i1, i2);
        return false;
      }
      break;
    case 6: 
      if (this.e != null)
      {
        i1 = paramMessage.arg1;
        this.e.j_(i1);
        return false;
      }
      break;
    case 5: 
      if ((this.d != null) && ((paramMessage.obj instanceof Integer)))
      {
        this.d.a(((Integer)paramMessage.obj).intValue());
        this.g = false;
        return false;
      }
      break;
    case 4: 
      if (this.d != null)
      {
        i1 = paramMessage.arg1;
        i2 = paramMessage.arg2;
        this.d.a(i1, i2);
        return false;
      }
      break;
    case 3: 
      paramMessage = this.d;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.g = false;
        return false;
      }
      break;
    case 2: 
      if (this.d != null)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof ArEffectConfig))
        {
          this.d.a((ArEffectConfig)paramMessage);
          return false;
        }
      }
      break;
    case 1: 
      if (this.d != null)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof ArConfigInfo))
        {
          this.d.a((ArConfigInfo)paramMessage);
          return false;
        }
      }
      break;
    case 0: 
      paramMessage = this.d;
      if (paramMessage != null) {
        paramMessage.a();
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager
 * JD-Core Version:    0.7.0.1
 */
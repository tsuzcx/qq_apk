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
import com.tencent.mobileqq.ar.aidl.IArMiniCallback;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.aidl.IArSoCallback;
import com.tencent.qphone.base.util.QLog;

public class RemoteArConfigManager
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public ServiceConnection a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RemoteArConfigManager");
  public IArConfigListener a;
  public IArFaceResourceListener a;
  private IArSoListener jdField_a_of_type_ComTencentMobileqqArIArSoListener;
  public IMiniResourceListener a;
  public ARCommonConfigInfo a;
  public ArConfigInfo a;
  public ArEffectConfig a;
  public IArConfigManager a;
  public IArFaceCallback a;
  public IArMiniCallback a;
  public IArRemoteCallback a;
  private IArSoCallback jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback = new RemoteArConfigManager.5(this);
  public boolean a;
  volatile boolean b = false;
  boolean c = false;
  
  public RemoteArConfigManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentServiceConnection = new RemoteArConfigManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback = new RemoteArConfigManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArFaceCallback = new RemoteArConfigManager.3(this);
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArMiniCallback = new RemoteArConfigManager.4(this);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public ARCommonConfigInfo a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = null;
        localObject1 = null;
      } while (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager == null);
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArConfig_RemoteArConfigManager", 1, "getARCommonConfigInfo fail!", localException);
        }
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_RemoteArConfigManager", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject2 }));
    return localObject2;
  }
  
  public ArConfigInfo a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public ArEffectConfig a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
    }
    for (;;)
    {
      return localObject2;
      Object localObject3 = null;
      localObject2 = null;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager == null) {
        continue;
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    if ((!this.b) || (this.jdField_a_of_type_AndroidContentContext != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = false;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = null;
      this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener = null;
      this.jdField_a_of_type_ComTencentMobileqqArIArSoListener = null;
      this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources type " + paramInt);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources|RemoteException e= " + localRemoteException);
    }
  }
  
  public void a(Context paramContext, IArConfigListener paramIArConfigListener, IMiniResourceListener paramIMiniResourceListener)
  {
    a(paramContext, false, paramIArConfigListener, null, null, paramIMiniResourceListener);
  }
  
  public void a(Context paramContext, boolean paramBoolean, IArConfigListener paramIArConfigListener, IArFaceResourceListener paramIArFaceResourceListener, IArSoListener paramIArSoListener, IMiniResourceListener paramIMiniResourceListener)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramBoolean;
    paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, ArConfigService.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(paramContext, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    this.b = true;
    if (paramIArConfigListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = paramIArConfigListener;
    }
    if (paramIArFaceResourceListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener = paramIArFaceResourceListener;
    }
    this.jdField_a_of_type_ComTencentMobileqqArIArSoListener = paramIArSoListener;
    this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener = paramIMiniResourceListener;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload|RemoteException e= " + localRemoteException);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onToolScannerActivityStateChanged state:" + paramInt + "  mConfigManager:" + this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.c(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.c();
      return bool1;
    }
    catch (Exception localException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_RemoteArConfigManager", 2, "isArSoReady fail!", localException);
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.c();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadArSo fail!", localException);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource type " + paramInt);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource|RemoteException e= " + localRemoteException);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            for (;;)
                            {
                              return false;
                              if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
                              {
                                this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a();
                                return false;
                                if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
                                {
                                  paramMessage = paramMessage.obj;
                                  if ((paramMessage instanceof ArConfigInfo))
                                  {
                                    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArConfigInfo)paramMessage);
                                    return false;
                                    if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
                                    {
                                      paramMessage = paramMessage.obj;
                                      if ((paramMessage instanceof ArEffectConfig))
                                      {
                                        this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArEffectConfig)paramMessage);
                                        return false;
                                        if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null) {
                                          try
                                          {
                                            if ((paramMessage.obj instanceof ARCommonConfigInfo))
                                            {
                                              this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ARCommonConfigInfo)paramMessage.obj);
                                              return false;
                                            }
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            QLog.e("ArConfig_RemoteArConfigManager", 1, "handleMessage AR_COMMON_CONFIG_UPDATE fail.", paramMessage);
                                            return false;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
                          this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.b();
                          this.jdField_a_of_type_Boolean = false;
                          return false;
                        } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
                        i = paramMessage.arg1;
                        j = paramMessage.arg2;
                        this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(i, j);
                        return false;
                      } while ((this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null) || (!(paramMessage.obj instanceof Integer)));
                      this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(((Integer)paramMessage.obj).intValue());
                      this.jdField_a_of_type_Boolean = false;
                      return false;
                    } while (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener == null);
                    i = paramMessage.arg1;
                    this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.l_(i);
                    return false;
                  } while (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener == null);
                  i = paramMessage.arg1;
                  j = paramMessage.arg2;
                  this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.a(i, j);
                  return false;
                } while (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener == null);
                i = paramMessage.arg1;
                j = paramMessage.arg2;
                this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.b(i, j);
                return false;
              } while (this.jdField_a_of_type_ComTencentMobileqqArIArSoListener == null);
              this.jdField_a_of_type_ComTencentMobileqqArIArSoListener.c();
              return false;
            } while (this.jdField_a_of_type_ComTencentMobileqqArIArSoListener == null);
            this.jdField_a_of_type_ComTencentMobileqqArIArSoListener.d();
            return false;
          } while (this.jdField_a_of_type_ComTencentMobileqqArIArSoListener == null);
          this.jdField_a_of_type_ComTencentMobileqqArIArSoListener.b(paramMessage.arg1);
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener == null);
        i = paramMessage.arg1;
        this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener.a(i);
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener == null);
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener.a(i, j);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener == null);
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    this.jdField_a_of_type_ComTencentMobileqqArIMiniResourceListener.b(i, j);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager
 * JD-Core Version:    0.7.0.1
 */
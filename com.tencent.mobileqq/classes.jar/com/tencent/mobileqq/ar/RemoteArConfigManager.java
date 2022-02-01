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
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public ServiceConnection a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RemoteArConfigManager");
  public IArConfigListener a;
  public IArFaceResourceListener a;
  private IArSoListener jdField_a_of_type_ComTencentMobileqqArIArSoListener;
  public ARCommonConfigInfo a;
  public ArConfigInfo a;
  public ArEffectConfig a;
  public IArConfigManager a;
  public IArFaceCallback a;
  public IArRemoteCallback a;
  private IArSoCallback jdField_a_of_type_ComTencentMobileqqArAidlIArSoCallback = new RemoteArConfigManager.4(this);
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
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public ARCommonConfigInfo a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    if (localObject1 != null) {
      return localObject1;
    }
    ARCommonConfigInfo localARCommonConfigInfo = null;
    localObject1 = null;
    IArConfigManager localIArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
    Object localObject2;
    if (localIArConfigManager != null)
    {
      try
      {
        localARCommonConfigInfo = localIArConfigManager.a();
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
  
  public ArConfigInfo a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    if (localObject != null) {
      return localObject;
    }
    StringBuilder localStringBuilder = null;
    IArConfigManager localIArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
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
  
  public ArEffectConfig a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = null;
    Object localObject4 = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
    Object localObject3;
    if (localObject1 != null)
    {
      try
      {
        localObject1 = ((IArConfigManager)localObject1).a();
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
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.b)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (localObject != null) {
        try
        {
          ((Context)localObject).unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      this.b = false;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = null;
    this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener = null;
    this.jdField_a_of_type_ComTencentMobileqqArIArSoListener = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
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
        this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(paramInt);
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
  }
  
  public boolean a()
  {
    IArConfigManager localIArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
    boolean bool2 = false;
    boolean bool3 = false;
    if (localIArConfigManager != null)
    {
      boolean bool1;
      try
      {
        bool1 = localIArConfigManager.a();
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b();
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
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onToolScannerActivityStateChanged state:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  mConfigManager:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager);
      QLog.d("ArConfig_RemoteArConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    IArConfigManager localIArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
    if (localIArConfigManager != null) {
      try
      {
        boolean bool = localIArConfigManager.b();
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
  
  public void c()
  {
    IArConfigManager localIArConfigManager = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager;
    if (localIArConfigManager != null) {
      try
      {
        localIArConfigManager.c();
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
    int i = paramMessage.what;
    int j;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        return false;
      case 102: 
        IArSoListener localIArSoListener = this.jdField_a_of_type_ComTencentMobileqqArIArSoListener;
        if (localIArSoListener != null)
        {
          localIArSoListener.b(paramMessage.arg1);
          return false;
        }
        break;
      case 101: 
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqArIArSoListener;
        if (paramMessage != null)
        {
          paramMessage.d();
          return false;
        }
        break;
      case 100: 
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqArIArSoListener;
        if (paramMessage != null)
        {
          paramMessage.c();
          return false;
        }
        break;
      }
      break;
    case 9: 
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
      break;
    case 8: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener != null)
      {
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.b(i, j);
        return false;
      }
      break;
    case 7: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener != null)
      {
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.a(i, j);
        return false;
      }
      break;
    case 6: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener != null)
      {
        i = paramMessage.arg1;
        this.jdField_a_of_type_ComTencentMobileqqArIArFaceResourceListener.h_(i);
        return false;
      }
      break;
    case 5: 
      if ((this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null) && ((paramMessage.obj instanceof Integer)))
      {
        this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(((Integer)paramMessage.obj).intValue());
        this.jdField_a_of_type_Boolean = false;
        return false;
      }
      break;
    case 4: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
      {
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(i, j);
        return false;
      }
      break;
    case 3: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener;
      if (paramMessage != null)
      {
        paramMessage.b();
        this.jdField_a_of_type_Boolean = false;
        return false;
      }
      break;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof ArEffectConfig))
        {
          this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArEffectConfig)paramMessage);
          return false;
        }
      }
      break;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener != null)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof ArConfigInfo))
        {
          this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArConfigInfo)paramMessage);
          return false;
        }
      }
      break;
    case 0: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener;
      if (paramMessage != null) {
        paramMessage.a();
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.RemoteArConfigManager
 * JD-Core Version:    0.7.0.1
 */
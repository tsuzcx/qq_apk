import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aovi
  implements aowr
{
  public aovi(ArConfigService paramArConfigService) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramInt);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        localRemoteException.printStackTrace();
      }
      aovr.a(localRemoteException.getCurrentAccountUin(), false, paramInt);
    }
    localQQAppInterface = (QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("ArConfig_ArConfigService", 1, "onDownloadError,mApp is null! ");
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramLong1, paramLong2);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a(null, null, paramARCommonConfigInfo);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramARCommonConfigInfo)
    {
      paramARCommonConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramArConfigInfo, null, null);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a(null, paramArEffectConfig, null);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArEffectConfig)
    {
      paramArEffectConfig.printStackTrace();
    }
  }
  
  public void b()
  {
    if (ArConfigService.a(this.a) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess before sync");
      }
    }
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync start");
      }
      try
      {
        int j = ArConfigService.a(this.a).beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              ((aoyj)ArConfigService.a(this.a).getBroadcastItem(i)).a();
              i += 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                localRemoteException.printStackTrace();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess  sync fail end,error reason:binder server muti-thread");
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess after sync");
        }
        ??? = (QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (??? != null) {
          break;
        }
        QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess,mApp is null! ");
        return;
        ArConfigService.a(this.a).finishBroadcast();
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync end");
    }
    aovr.a(((QQAppInterface)???).getCurrentAccountUin(), true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovi
 * JD-Core Version:    0.7.0.1
 */
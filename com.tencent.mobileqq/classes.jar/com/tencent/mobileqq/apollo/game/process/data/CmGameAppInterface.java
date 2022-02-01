package com.tencent.mobileqq.apollo.game.process.data;

import android.content.Intent;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.game.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class CmGameAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public static final int a = QQManagerFactory.COUNT_MANAGER;
  public static final int b = a + 1;
  public static final String c = CmGameSSoHandler.class.getName();
  private EntityManagerFactory d;
  private Map<Integer, Manager> e = new HashMap(20);
  
  public CmGameAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    CmGameClientQIPCModule.b();
  }
  
  @Nullable
  private Manager a(int paramInt)
  {
    Object localObject1 = (Manager)this.e.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.e)
    {
      if (paramInt == a) {
        localObject1 = new CmGameManager(this);
      } else if (paramInt == b) {
        localObject1 = new NetEngineFactory();
      } else if (paramInt == QQManagerFactory.DOWNLOADER_FACTORY) {
        localObject1 = new DownloaderFactory(this);
      }
      Object localObject3;
      if (this.e.get(Integer.valueOf(paramInt)) != null)
      {
        localObject3 = (Manager)this.e.get(Integer.valueOf(paramInt));
      }
      else
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          this.e.put(Integer.valueOf(paramInt), localObject1);
          localObject3 = localObject1;
        }
      }
      return localObject3;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.d();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.d == null) {
      this.d = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.d;
  }
  
  public Manager getManager(int paramInt)
  {
    try
    {
      Manager localManager2 = a(paramInt);
      Manager localManager1 = localManager2;
      if (localManager2 == null) {
        localManager1 = super.getManager(paramInt);
      }
      return localManager1;
    }
    finally {}
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public void onBeforeExitProc()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onBeforeExitProc]");
  }
  
  public void onDestroy()
  {
    synchronized (this.e)
    {
      Object localObject1 = this.e.keySet();
      if (((Set)localObject1).size() == 0) {
        return;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Manager localManager = (Manager)this.e.get(((Iterator)localObject1).next());
        if (localManager != null) {
          try
          {
            localManager.onDestroy();
          }
          catch (Exception localException)
          {
            QLog.e("cmgame_process.CmGameAppInterface", 1, "onDestroy", localException);
          }
        }
      }
      this.e.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveAccountAction]");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */
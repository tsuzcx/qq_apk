package com.tencent.mobileqq.apollo.process.data;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class CmGameAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public static final int a;
  public static final String a;
  public static final int b;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  
  static
  {
    jdField_a_of_type_Int = QQManagerFactory.COUNT_MANAGER;
    b = jdField_a_of_type_Int + 1;
    jdField_a_of_type_JavaLangString = CmGameSSoHandler.class.getName();
  }
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    CmGameClientQIPCModule.a();
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new CmGameAppInterface.1(this));
  }
  
  private void a()
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a();
    if (localCmGameLauncher != null) {
      CmGameUtil.a(localCmGameLauncher.a());
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localObject4 = localObject1;
        if (localObject1 == null) {}
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          if (paramInt == jdField_a_of_type_Int)
          {
            localObject1 = new CmGameManager(this);
            if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
              break label155;
            }
            localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = super.getManager(paramInt);
            }
            return localObject1;
          }
          if (paramInt == b)
          {
            localObject1 = new NetEngineFactory();
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject1);
          }
        }
        if (paramInt != QQManagerFactory.DOWNLOADER_FACTORY) {
          continue;
        }
      }
      finally {}
      DownloaderFactory localDownloaderFactory = new DownloaderFactory(this);
      continue;
      label155:
      Object localObject4 = localDownloaderFactory;
      if (localDownloaderFactory != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localDownloaderFactory);
        localObject4 = localDownloaderFactory;
      }
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public void onBeforeExitProc()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onBeforeExitProc]");
    a();
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        do
        {
          for (;;)
          {
            boolean bool = ((Iterator)localObject1).hasNext();
            if (!bool) {
              break label114;
            }
            try
            {
              Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject1).next());
              if (localManager != null) {
                localManager.onDestroy();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("cmgame_process.CmGameAppInterface", 2, "onDesotry", localException);
      }
    }
    label114:
    this.jdField_a_of_type_JavaUtilMap.clear();
    ApolloSoLoaderImpl.removeFileObserver();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveAccountAction]");
    a();
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveLegalExitProcAction]");
    if (CmGameUtil.a() != null)
    {
      QLog.i("cmgame_process.CmGameAppInterface", 1, "NOT kill tool process");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */
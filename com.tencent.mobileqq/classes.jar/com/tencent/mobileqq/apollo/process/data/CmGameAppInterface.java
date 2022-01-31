package com.tencent.mobileqq.apollo.process.data;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class CmGameAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  List jdField_a_of_type_JavaUtilList = new Vector();
  Map jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[1];
  List b = new Vector();
  List c = new Vector();
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    CmGameClientQIPCModule.a();
  }
  
  private void a()
  {
    CmGameLauncher localCmGameLauncher = CmGameUtil.a();
    if (localCmGameLauncher != null) {
      CmGameUtil.a(localCmGameLauncher.a());
    }
  }
  
  private BusinessHandler b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new CmGameSSoHandler(this);
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramBusinessObserver)) {
          this.b.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a;
  }
  
  public List getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.b;
    }
    if (paramInt == 0) {
      return this.c;
    }
    return this.c;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
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
        localObject5 = localObject1;
        Map localMap;
        if (localObject1 == null) {
          localMap = this.jdField_a_of_type_JavaUtilMap;
        }
        switch (paramInt)
        {
        default: 
        case 255: 
          try
          {
            if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
              break;
            }
            localObject5 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
            localObject1 = localObject5;
            if (localObject5 == null) {
              localObject1 = super.getManager(paramInt);
            }
            return localObject1;
          }
          finally {}
          localObject1 = new CmGameManager(this);
          break;
        case 256: 
          localObject4 = new NetEngineFactory();
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject4);
      continue;
      Object localObject4 = new DownloaderFactory(this);
      continue;
      Object localObject5 = localObject4;
      if (localObject4 != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject4);
        localObject5 = localObject4;
      }
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(256));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
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
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
      synchronized (this.b)
      {
        this.b.remove(paramBusinessObserver);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramBusinessObserver);
      return;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */
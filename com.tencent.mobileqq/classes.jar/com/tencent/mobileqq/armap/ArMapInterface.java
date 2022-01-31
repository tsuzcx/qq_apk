package com.tencent.mobileqq.armap;

import abje;
import abjf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.AccountManagerImpl;
import mqq.app.IToolProcEventListener;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class ArMapInterface
  extends AppInterface
  implements IToolProcEventListener
{
  ArMapService jdField_a_of_type_ComTencentMobileqqArmapArMapService;
  public NonMainAppHeadLoader a;
  private PoiExtraMng jdField_a_of_type_ComTencentMobileqqArmapPoiExtraMng;
  private ResDownloadManager jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager;
  public ArMapIPC a;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap(20);
  private boolean jdField_a_of_type_Boolean;
  private Object b;
  public List b;
  public List c;
  public List d;
  
  public ArMapInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public BusinessHandler a(int paramInt)
  {
    BusinessHandler localBusinessHandler1 = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localBusinessHandler1 == null) {}
    for (;;)
    {
      BusinessHandler localBusinessHandler2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localBusinessHandler2 = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localBusinessHandler2 == null) {
          break label94;
        }
        return localBusinessHandler2;
        if (localBusinessHandler1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBusinessHandler1);
        }
        return localBusinessHandler1;
      }
      Object localObject2 = new ArMapHandler(this);
      continue;
      return localObject2;
      label94:
      localObject2 = localBusinessHandler2;
      switch (paramInt)
      {
      }
      localObject2 = localBusinessHandler2;
    }
  }
  
  public ResDownloadManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)getManager(211));
    }
    return this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager;
  }
  
  public void a()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((NetChangedListener)localIterator.next()).a();
    }
  }
  
  public void a(NetChangedListener paramNetChangedListener)
  {
    if (!this.d.contains(paramNetChangedListener)) {
      this.d.add(paramNetChangedListener);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
      }
    }
    while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void b()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((NetChangedListener)localIterator.next()).b();
    }
  }
  
  public void b(NetChangedListener paramNetChangedListener)
  {
    this.d.remove(paramNetChangedListener);
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
      return this.jdField_b_of_type_JavaUtilList;
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
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactory(getAccount());
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAccount()))) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = new QQEntityManagerFactory(paramString);
        ThreadManager.post(new abje(this), 5, null, false);
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject3;
    if (localObject1 == null)
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      switch (paramInt)
      {
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
            break label317;
          }
          localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
          return localObject4;
        }
        finally {}
        localObject1 = new AccountManagerImpl(this);
        continue;
        localObject3 = new WtloginManagerImpl(this);
        continue;
        localObject3 = new TicketManagerImpl(this);
        continue;
        localObject3 = new ProxyIpManagerImpl(this);
        continue;
        localObject3 = new NetEngineFactory();
        continue;
        localObject3 = new ARMapManager(this);
        continue;
        localObject3 = new NetEngineFactory();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject3);
        continue;
        localObject3 = new ResDownloadManager(this);
        this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)localObject3);
        continue;
        localObject3 = new PoiExtraMng(this);
        this.jdField_a_of_type_ComTencentMobileqqArmapPoiExtraMng = ((PoiExtraMng)localObject3);
        continue;
        localObject3 = new DeviceProfileManager.AccountDpcManager(this);
        continue;
        localObject3 = new LbsPackManager(this);
        continue;
        label317:
        Object localObject4 = localObject3;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject3);
          localObject4 = localObject3;
        }
      }
    }
    return localObject3;
  }
  
  public String getModuleId()
  {
    return "module_armap";
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(208));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ArMapInterface", 4, "onBeforeExitProc");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_b_of_type_JavaUtilList = new Vector();
    this.c = new Vector();
    this.d = new Vector();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapService = new ArMapService(this);
    this.jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC = ArMapIPC.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = new NonMainAppHeadLoader(getApp(), 1);
    this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a();
    ThreadManager.post(new abjf(this), 8, null, true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ArMapIPC.a().b();
    this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.b();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          try
          {
            DeviceProfileManager.a(this, 213).b(this);
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              Object localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet();
              if ((localObject2 == null) || (((Set)localObject2).size() <= 0)) {
                break;
              }
              localObject2 = ((Set)localObject2).iterator();
              bool = ((Iterator)localObject2).hasNext();
              if (!bool) {
                break;
              }
              try
              {
                Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject2).next());
                if (localManager == null) {
                  continue;
                }
                localManager.onDestroy();
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              NearbyUtils.a("ArMapInterface", new Object[] { "onDestroy", localException2.toString() });
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            continue;
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ArMapInterface", 4, "onReceiveAccountAction");
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ArMapInterface", 4, "onReceiveLegalExitProcAction");
    }
    return false;
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.c.remove(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapService.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapInterface
 * JD-Core Version:    0.7.0.1
 */